package TestTask.com.gridnine.testing;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class GroundTimeExceedsTwoHoursFilter implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    long totalGroundTime = 0;

                    for (int i = 0; i < segments.size() - 1; i++) {
                        Segment currentSegment = segments.get(i);
                        Segment nextSegment = segments.get(i + 1);
                        totalGroundTime += Duration.between(currentSegment.getArrivalDate(), nextSegment.getDepartureDate()).toMinutes();
                    }

                    return totalGroundTime <= 120; // 120 минут = 2 часа
                })
                .collect(Collectors.toList());
    }
}