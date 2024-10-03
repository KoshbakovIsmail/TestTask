package TestTask.com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroundTimeExceedsTwoHoursFilterTest {

    @Test
    public void testFilter() {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter filter = new GroundTimeExceedsTwoHoursFilter();
        List<Flight> filteredFlights = filter.filter(flights);

        // Ожидаем, что рейсы с временем на земле более двух часов будут исключены
        assertEquals(5, filteredFlights.size());

    }
}