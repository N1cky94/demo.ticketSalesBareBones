package be.archilios.demos.ticketsales.event.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@Tag("unit")
class EventTicketBehaviourTest {
    Event eventToTest;

    @BeforeEach
    void init() {
        eventToTest = Event.createNewEvent(
                "Test Event",
                LocalDateTime.of(2024, 1, 5, 10, 0),
                LocalDateTime.of(2024, 1, 6, 2, 0),
                "Test Location",
                100
        );
    }

    @Test
    void reserveTickets() {
        final int expectedAvailableTickets = 90;

        eventToTest.reserveTicket(10);

        assertEquals(expectedAvailableTickets, eventToTest.getAvailableTickets());
    }

    @Test
    void releaseTickets() {
        final int expectedAvailableTickets = 90;

        eventToTest.reserveTicket(20);
        eventToTest.releaseTickets(10);

        assertEquals(expectedAvailableTickets, eventToTest.getAvailableTickets());
    }

}