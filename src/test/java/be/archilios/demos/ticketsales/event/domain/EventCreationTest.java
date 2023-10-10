package be.archilios.demos.ticketsales.event.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("unit")
public class EventCreationTest {
     final String EVENT_NAME = "Test Event";
     final Location EVENT_LOCATION = new Location(
             "Dev Home",
             "Kneukelstraat",
             "39",
             "Aalter",
             "9880",
             "Belgium"
     );
     final int EVENT_CAPACITY = 100;
     final LocalDateTime EVENT_START = LocalDateTime.of(2024, 1, 5, 10, 0);
     final LocalDateTime EVENT_END = LocalDateTime.of(2024, 1, 6, 2, 0);

    @Test
    void eventIsCreatedAccordingToExpectations() {
        Event eventToTest = Event.createNewEvent(
                EVENT_NAME,
                EVENT_START,
                EVENT_END,
                EVENT_LOCATION,
                EVENT_CAPACITY
        );

        assertEquals(eventToTest.getName(), EVENT_NAME);
        assertEquals(eventToTest.getStart(), EVENT_START);
        assertEquals(eventToTest.getEnd(), EVENT_END);
        assertEquals(eventToTest.getLocation(), EVENT_LOCATION);
        assertEquals(eventToTest.getCapacity(), EVENT_CAPACITY);
        assertEquals(eventToTest.getAvailableTickets(), EVENT_CAPACITY);
    }
    @Test
    void createEventWithEndDateBeforeStartDate() {
        assertThrows(IllegalArgumentException.class, () -> Event.createNewEvent(
                EVENT_NAME,
                EVENT_START,
                LocalDateTime.of(2024, 1, 5, 9, 59),
                EVENT_LOCATION,
                EVENT_CAPACITY
        ));
    }

    @Test
    void createEventWithNoAvailableTickets() {
        assertThrows(IllegalArgumentException.class, () -> Event.createNewEvent(
                EVENT_NAME,
                EVENT_START,
                EVENT_END,
                EVENT_LOCATION,
                0
        ));
    }

    @Test
    void createEventWithNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> Event.createNewEvent(
                EVENT_NAME,
                EVENT_START,
                EVENT_END,
                EVENT_LOCATION,
                -1
        ));
    }
}
