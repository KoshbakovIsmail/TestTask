package TestTask.com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightFilterProcessorTest {

    @Test
    public void testFilter() {
        List<Flight> flights = FlightBuilder.createFlights();
        List<FlightFilter> filters = Arrays.asList(
                new DepartureBeforeNowFilter(),
                new ArrivalBeforeDepartureFilter(),
                new GroundTimeExceedsTwoHoursFilter()
        );

        FlightFilterProcessor processor = new FlightFilterProcessor(filters);
        List<Flight> filteredFlights = processor.filter(flights);

        // Ожидаем, что останутся только те рейсы, которые проходят все фильтры
        assertEquals(3, filteredFlights.size());
    }
}
