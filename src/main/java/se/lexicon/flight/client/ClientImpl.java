package se.lexicon.flight.client;

import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.Flight;
import se.lexicon.flight.service.AirlineService;
import se.lexicon.flight.service.FlightService;

import java.util.Objects;

public class ClientImpl implements Client {

    private AirlineService airlineService;

    private FlightService flightService;

    public ClientImpl(){

    }

    public ClientImpl(AirlineService airlineService,FlightService flightService) {
        this.airlineService=Objects.requireNonNull(airlineService,"airlineService should not null");
        this.flightService= Objects.requireNonNull(flightService,"flightService should not null");
    }

    @Override
    public Airline searchAirlineByName(String airlineName) {
        return airlineService.searchAirlineByName(airlineName);
    }

    @Override
    public Flight searchFlightByFlightNo(String flightNo){
        return flightService.searchFlightByFlightNo(flightNo);
    }
}
