package station;

import java.util.ArrayList;

// Train class creates an object Train to store in the station objects and 
// also exists as a place to store passengers, objects from the Person class

public class Train {
	private int trainNumber;
	private int numSeats;
	private String[] destinations;
	private ArrayList<Person> passengers = new ArrayList<Person>();

	// Constructor to give parameters to the Train class object
	public Train(int trainNumber, int numSeats, String[] destinations) {
		this.trainNumber = trainNumber;
		this.numSeats = numSeats;
		this.destinations = destinations;
	}

	// Getters and setters for the fields in the Train class
	/**
	 * @return the trainNumber
	 */
	public int getTrainNumber() {
		return trainNumber;
	}

	/**
	 * @param trainNumber
	 *            the trainNumber to set
	 */
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	/**
	 * @return the numSeats
	 */
	public int getNumSeats() {
		return numSeats;
	}

	/**
	 * @param numSeats
	 *            the numSeats to set
	 */
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	/**
	 * @return the destinations
	 */
	public String[] getDestinations() {
		return destinations;
	}

	/**
	 * @param destinations
	 *            the destinations to set
	 */
	public void setDestinations(String[] destinations) {
		this.destinations = destinations;
	}

	public ArrayList<Person> getPassengers() {
		return passengers;
	}

	public void setPassengers(ArrayList<Person> passengers) {
		this.passengers = passengers;
	}

	// returns the number of people who have a given name on a train
	public int getNumNames(String name) {
		int cnt = 0;
		for (int i = 0; i < passengers.size(); i++) {
			if (passengers.get(i).getName().equals(name) && passengers.get(i).getName() != null) {
				cnt++;
			}
		}
		return cnt;
	}

	// Returns true if a train is going to a certain city
	public boolean trainHasCity(String city) {
		for (int i = 0; i < destinations.length; i++) {
			if (destinations[i].equals(city)) {
				return true;
			}
		}
		return false;
	}

	// Returns the number of people on a train that are going to a certain city
	public int destinationCountPeople(String city) {
		int cnt = 0;
		for (int i = 0; i < passengers.size(); i++) {
			if (passengers.get(i).getDestinationCity().equals(city)) {
				cnt++;
			}
		}
		return cnt;
	}

	// Adds a passenger to a train
	public void addToTrain(Person p) {
		passengers.add(p);
	}

	// Hashcode and equals method for Train class

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numSeats;
		result = prime * result + trainNumber;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Train))
			return false;
		Train other = (Train) obj;
		if (numSeats != other.numSeats)
			return false;
		if (trainNumber != other.trainNumber)
			return false;
		return true;
	}

}
