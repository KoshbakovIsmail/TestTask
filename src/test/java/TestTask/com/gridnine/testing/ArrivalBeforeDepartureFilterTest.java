package TestTask.com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrivalBeforeDepartureFilterTest {

    @Test
    public void testFilterWhenAllSegmentsValid() {
        LocalDateTime now = LocalDateTime.now();
        List<Segment> segments = Arrays.asList(
                new Segment(now, now.plusHours(2)),
                new Segment(now.plusHours(3), now.plusHours(5))
        );
        Flight flight = new Flight(segments);
        List<Flight> flights = Arrays.asList(flight);

        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();
        List<Flight> filteredFlights = filter.filter(flights);

        // Ожидаем, что рейс останется, так как все сегменты валидны
        assertEquals(1, filteredFlights.size());
    }

    @Test
    public void testFilterWhenSomeSegmentsInvalid() {
        LocalDateTime now = LocalDateTime.now();
        List<Segment> validSegments = Arrays.asList(
                new Segment(now, now.plusHours(2)),
                new Segment(now.plusHours(3), now.plusHours(5))
        );
        List<Segment> invalidSegments = Arrays.asList(
                new Segment(now, now.minusHours(2)),
                new Segment(now.plusHours(3), now.plusHours(1))
        );
        Flight validFlight = new Flight(validSegments);
        Flight invalidFlight = new Flight(invalidSegments);
        List<Flight> flights = Arrays.asList(validFlight, invalidFlight);

        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();
        List<Flight> filteredFlights = filter.filter(flights);

        // Ожидаем, что останется только валидный рейс
        assertEquals(1, filteredFlights.size());
        assertEquals(validFlight, filteredFlights.get(0));
    }

    @Test
    public void testFilterWhenAllSegmentsInvalid() {
        LocalDateTime now = LocalDateTime.now();
        List<Segment> invalidSegments = Arrays.asList(
                new Segment(now, now.minusHours(2)),
                new Segment(now.plusHours(3), now.plusHours(1))
        );
        Flight invalidFlight = new Flight(invalidSegments);
        List<Flight> flights = Arrays.asList(invalidFlight);

        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();
        List<Flight> filteredFlights = filter.filter(flights);

        // Ожидаем, что все рейсы будут исключены
        assertEquals(0, filteredFlights.size());
    }

    @Test
    public void testFilterWhenEmptyFlightList() {
        List<Flight> flights = Arrays.asList();

        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();
        List<Flight> filteredFlights = filter.filter(flights);

        // Ожидаем, что результат будет пустым
        assertEquals(0, filteredFlights.size());

    }
}