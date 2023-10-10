package be.archilios.demos.ticketsales.event.domain;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class Event {
    private Long id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private Location location;
    private int capacity;
    private int availableTickets;

    public static Event createNewEvent(String name, LocalDateTime start, LocalDateTime end, Location location, int capacity) {
        return EventFactory.createNewEvent(name, start, end, location, capacity);
    }

    public void reserveTicket(int numberOfTickets) {
        if (numberOfTickets < 1) throw new IllegalArgumentException("Cannot reserve less than 1 ticket");
        if (availableTickets < numberOfTickets) throw new IllegalArgumentException("Not enough tickets available");

        availableTickets -= numberOfTickets;
    }

    public void releaseTickets(int numberOfTickets) {
        if (numberOfTickets < 1) throw new IllegalArgumentException("Cannot release less than 1 ticket");
        if (availableTickets + numberOfTickets > capacity) throw new IllegalArgumentException("Cannot release more tickets than the capacity of the event");

        availableTickets += numberOfTickets;
    }
}

class EventFactory {
    static Event createNewEvent(String name, LocalDateTime start, LocalDateTime end, Location location, int capacity) {
        return new Event(
                null,
                name,
                start,
                validateEndDate(start, end),
                location,
                validateCapacity(capacity),
                capacity
        );
    }

    private static LocalDateTime validateEndDate(LocalDateTime start, LocalDateTime end) {
        if (end.isBefore(start)) throw new IllegalArgumentException("End date cannot be before start date");
        return end;
    }

    private static int validateCapacity(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException("Cannot create an event with no available tickets");
        return capacity;
    }
}