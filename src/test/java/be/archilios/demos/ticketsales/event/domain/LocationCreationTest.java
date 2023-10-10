package be.archilios.demos.ticketsales.event.domain;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("unit")
public class LocationCreationTest {
    Location locationToTest;
    Location locationToCheck;

    @BeforeEach()
    void init() {
        locationToTest = new Location(
                "Dev Home",
                "Kneukelstraat",
                "39",
                "Aalter",
                "9880",
                "Belgium"
        );
        locationToCheck = new Location(
                "Dev Home",
                "Kneukelstraat",
                "39",
                "Aalter",
                "9880",
                "Belgium"
        );
    }

    @Test
    void locationIsCreatedAccordingToExpectations() {
        assertEquals(locationToTest, locationToCheck, "Location equals is not working as expected.");
    }
}
