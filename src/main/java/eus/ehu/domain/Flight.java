package eus.ehu.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Flight
 *
 * An object of this class represents an actual air link between two cities
 * The objects of the complementary class "Concrete Flight" represent actual
 * flights scheduled for this air link
 */
public class Flight {

	private String flightCode;
	private String departureCity;
	private String arrivalCity;
	private List<ConcreteFlight> concreteFlights;

	public Flight(String flightCode, String departureCity, String arrivalCity) {
		super();
		this.flightCode = flightCode;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.concreteFlights = new ArrayList<ConcreteFlight>();
	}


	public String getFlightCode() {
		return flightCode;
	}


	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}


	public String getDepartureCity() {
		return departureCity;
	}


	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}


	public String getArrivalCity() {
		return arrivalCity;
	}


	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}


	public void addConcreteFlight(ConcreteFlight conFl) {
		concreteFlights.add(conFl);
	}


	public ArrayList<ConcreteFlight> getConcreteFlights() {
		ArrayList<ConcreteFlight> l = new ArrayList<ConcreteFlight>();
		l.addAll(concreteFlights);
		return l;
	}


	public ArrayList<ConcreteFlight> getConcreteFlights(Date date) {
		ArrayList<ConcreteFlight> lInDate = new ArrayList<ConcreteFlight>();
		for (ConcreteFlight cfl : concreteFlights) {
			if (date.equals(cfl.getDate()))
				lInDate.add(cfl);
		}
		return lInDate;
	}

	public ArrayList<ConcreteFlight> getConcreteFlightsNew(Date date, String fare, int quantity ) {
		ArrayList<ConcreteFlight> lInDate = new ArrayList<ConcreteFlight>();
		for (ConcreteFlight cfl : concreteFlights) {
			if (date.equals(cfl.getDate()))
				switch(fare)
				{
					case "Economy":
					if(cfl.getFreeEconomySeatNo()>=quantity){
						lInDate.add(cfl);
					}
					break;
					case "Business":
					if(cfl.getFreeBusinessSeatNo()>=quantity){
						lInDate.add(cfl);
					}
					break;
					//case "First Class":
					default:
					if(cfl.getFreeFirstSeatNo()>=quantity){
						lInDate.add(cfl);
					}
				}
		}
		return lInDate;
	}


	public void setConcreteFlights(List<ConcreteFlight> concreteFlights) {
		this.concreteFlights = concreteFlights;
	}


	public String toString() {
		return flightCode + ": " + departureCity + " -> " + arrivalCity;
	}

}
