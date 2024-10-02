package TestTask.com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FlightBuilderTest {

    @Test
    public void testCreateFlights() {
        List<Flight> flights = FlightBuilder.createFlights();
        assertEquals(6, flights.size());
    }

    @Test
    public void testCreateFlightWithOddNumberOfDates() {
        assertThrows(IllegalArgumentException.class, () -> {
            FlightBuilder.createFlight(LocalDateTime.now());
        });
    }

    @Test
    public void testCreateFlightWithEvenNumberOfDates() {
        LocalDateTime now = LocalDateTime.now();
        Flight flight = FlightBuilder.createFlight(now, now.plusHours(2), now.plusHours(3), now.plusHours(5));
        assertEquals(2, flight.getSegments().size());
    }
}