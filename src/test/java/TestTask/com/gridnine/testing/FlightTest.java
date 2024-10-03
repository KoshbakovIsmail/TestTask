package TestTask.com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightTest {

    @Test
    public void testGetSegments() {
        LocalDateTime now = LocalDateTime.now();
        List<Segment> segments = Arrays.asList(
                new Segment(now, now.plusHours(2)),
                new Segment(now.plusHours(3), now.plusHours(5))
        );
        Flight flight = new Flight(segments);

        assertEquals(segments, flight.getSegments());
    }

    @Test
    public void testToString() {
        LocalDateTime now = LocalDateTime.now();
        List<Segment> segments = Arrays.asList(
                new Segment(now, now.plusHours(2)),
                new Segment(now.plusHours(3), now.plusHours(5))
        );
        Flight flight = new Flight(segments);

        String expected = segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
        assertEquals(expected, flight.toString());

    }
}