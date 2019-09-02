package se.lexicon.flight.daoImpl;

import se.lexicon.flight.dao.FlightDao;
import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.Flight;

import java.util.*;
import java.util.stream.Collectors;

public class FlightDaoImpl implements FlightDao {

    private Map<String,Flight> flights = new HashMap<>();

    public FlightDaoImpl(){

    }

    public FlightDaoImpl(Map<String,Flight> flights){
        this.flights=Objects.requireNonNull(flights);
    }

    @Override
    public void addFlight(Flight flight) {
        if(flights.containsKey(flight.getFlightNo())){
            throw new RuntimeException("Flight is Exist");
        }
        flights.put(flight.getFlightNo(),flight);

    }

    @Override
    public Collection<Flight> searchFlightByAirlineName(String airlineName) {
        Collection<Flight> flightsByAirlineName =flights.values().stream().filter(flight -> flight.getAirline().getAirlineName()
                .equalsIgnoreCase(airlineName)).collect(Collectors.toList());
        if (flightsByAirlineName.isEmpty()){
            System.out.println("No Flight is Found By " +airlineName);
        }
        return flightsByAirlineName;
    }

    @Override
    public Collection<Flight> searchFlightByCityAndDate(String fromCity, String toCity, String departureDate) {
        Collection<Flight> flight1= flights.values().stream().filter(flight -> flight.getFromCity().equalsIgnoreCase(fromCity)
                       && flight.getToCity().equalsIgnoreCase(toCity)
                       && flight.getDepartureDate().equalsIgnoreCase(departureDate))
                       .collect(Collectors.toList());

        if(flight1.isEmpty()){
            System.out.println("No Flight is Available ");
        }
        return flight1;
    }

    @Override
    public List<Flight> getFlights(){
        return flights.values().stream().map(f-> Flight.builder()
                .withFlightNo(f.getFlightNo()).withFlightName(f.getFlightName()).withDepartureDate(f.getDepartureDate()).withReturningDate(f.getReturningDate())
                .withFromCity(f.getFromCity()).withToCity(f.getToCity()).withAirline(Airline.builder().withId(f.getAirline().getId()).withAirlineName(f.getAirline().getAirlineName())
                .withAirlineCode(f.getAirline().getAirlineCode()).build()).withClassType(f.getClassType()).withTotalSeat(f.getTotalSeats())
                .withTrip(f.getTrip()).withTicketPrice(f.getTicketPrice()).build()).collect(Collectors.toList());
    }

    @Override
    public void cancelFlight(String flightNo) {
        List<Flight>flightList=(flights.values().stream().filter(flight1 -> flight1.getFlightNo().equalsIgnoreCase(flightNo)).collect(Collectors.toList()));
        if (flightList.contains(flightNo)){
            flightList.remove(flightNo);
        }else {
            System.out.println("No such Flight is Available ");
        }
    }
}
