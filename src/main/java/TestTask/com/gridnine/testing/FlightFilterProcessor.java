package TestTask.com.gridnine.testing;

import java.util.List;

public class FlightFilterProcessor {
    private final List<FlightFilter> filters;

    public FlightFilterProcessor(List<FlightFilter> filters) {
        this.filters = filters;
    }

    public List<Flight> filter(List<Flight> flights) {
        List<Flight> filteredFlights = flights;
        for (FlightFilter filter : filters) {
            filteredFlights = filter.filter(filteredFlights);
        }
        return filteredFlights;

    }
}
