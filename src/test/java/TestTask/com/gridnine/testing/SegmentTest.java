package TestTask.com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SegmentTest {

    @Test
    public void testGetDepartureDate() {
        LocalDateTime now = LocalDateTime.now();
        Segment segment = new Segment(now, now.plusHours(2));
        assertEquals(now, segment.getDepartureDate());
    }

    @Test
    public void testGetArrivalDate() {
        LocalDateTime now = LocalDateTime.now();
        Segment segment = new Segment(now, now.plusHours(2));
        assertEquals(now.plusHours(2), segment.getArrivalDate());
    }

    @Test
    public void testToString() {
        LocalDateTime now = LocalDateTime.now();
        Segment segment = new Segment(now, now.plusHours(2));
        String expected = '[' + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")) + '|' + now.plusHours(2).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")) + ']';
        assertEquals(expected, segment.toString());
    }

    @Test
    public void testConstructorWithNullDepartureDate() {
        LocalDateTime now = LocalDateTime.now();
        assertThrows(NullPointerException.class, () -> {
            new Segment(null, now.plusHours(2));
        });
    }

    @Test
    public void testConstructorWithNullArrivalDate() {
        LocalDateTime now = LocalDateTime.now();
        assertThrows(NullPointerException.class, () -> {
            new Segment(now, null);
        });
    }
}