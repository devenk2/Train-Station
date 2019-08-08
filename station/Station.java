package station;

import java.util.ArrayList;

public class Station {

	// ArrayList to store the trains
	ArrayList<Train> station = new ArrayList<Train>();

	// Method adds train to the station if the station is holding less than 25
	// trains, the train has a valid number of seats,
	// the array of destinations is not null, and the station does not already have
	// the train.
	private String[] validDestinations(String[] destinations) {
		if (destinations == null) {
			return null;
		}
		int size = 0;
		for (String s : destinations) {
			if (s != null) {
				size++;
			}
		}
		String[] result = new String[size];
		int i = 0;
		if (size == 0) {
			result = null;
		} else {
			for (String s : destinations) {
				if (s != null) {
					result[i] = s;
					i++;
				}
			}
		}
		return result;
	}

	public Station addTrainToStation(int trainNumber, int numSeats, String[] destinations) {
		Train t = new Train(trainNumber, numSeats, validDestinations(destinations));
		if ((station.size() < 25) && (numSeats >= 0) && (destinations != null) && !station.contains(t)) {
			station.add(t);
		}
		return this;
	}

	// Method returns number of trains at a station
	public int numTrainsAtStation() {
		return station.size();
	}

	// Method adds passenger to a train with the given train number and returns
	// false if the station does not contain the specific train
	public boolean addPersonToTrain(int trainNumber, String name, String destinationCity) {
		Person w = new Person(trainNumber, name, destinationCity);
		for (int i = 0; i < station.size(); i++) {
			Train t = station.get(i);
			if (t.getTrainNumber() == trainNumber && t.trainHasCity(destinationCity) && name != null
					&& destinationCity != null) {
				if (t.getPassengers().size() < t.getNumSeats()) {
					t.addToTrain(w);
					return true;
				}
			}
		}
		return false;
	}

	// Method returns the number of people on a given train
	public int numPeopleOnTrain(int trainNumber) {
		for (int i = 0; i < station.size(); i++) {
			if (station.get(i).getTrainNumber() == trainNumber) {
				return station.get(i).getPassengers().size();
			}
		}
		return -1;
	}

	// Method returns number of people with a given name on a given train
	public int numPeopleOnTrain(int trainNumber, String name) {
		for (int i = 0; i < station.size(); i++) {
			if (station.get(i).getTrainNumber() == trainNumber && name != null) {
				return station.get(i).getNumNames(name);
			}
		}
		return -1;
	}

	// Method returns the number of trains going to a given city
	public int numTrainsGoingToCity(String city) {
		int cnt = 0;
		if (city == null) {
			return 0;
		}
		for (int i = 0; i < station.size(); i++) {
			if (station.get(i).trainHasCity(city) == true) {
				cnt++;
			}
		}
		return cnt;
	}

	// Method returns the number of people going to a given city
	public int numPeopleGoingToCity(String city) {
		int cnt = 0;
		if (city == null) {
			return 0;
		}
		for (int i = 0; i < station.size(); i++) {
			cnt += station.get(i).destinationCountPeople(city);
		}
		return cnt;
	}

	// Method removes a train from a station and returns false if the train is not
	// originally in the station
	public boolean cancelTrain(int trainNumber) {
		for (int i = 0; i < station.size(); i++) {
			if (station.get(i).getTrainNumber() == trainNumber) {
				station.remove(station.get(i));
				return true;
			}
		}
		return false;
	}

}
