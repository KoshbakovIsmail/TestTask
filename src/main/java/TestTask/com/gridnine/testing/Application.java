package TestTask.com.gridnine.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		List<Flight> flights = FlightBuilder.createFlights();

		System.out.println("All Flights:");
		flights.forEach(System.out::println);

		List<FlightFilter> filters = Arrays.asList(
				new DepartureBeforeNowFilter(),
				new ArrivalBeforeDepartureFilter(),
				new GroundTimeExceedsTwoHoursFilter()
		);

		FlightFilterProcessor processor = new FlightFilterProcessor(filters);
		List<Flight> filteredFlights = processor.filter(flights);

		System.out.println("\nFiltered Flights:");
		filteredFlights.forEach(System.out::println);
	}
}
