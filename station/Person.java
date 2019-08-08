package station;

// Person class creates objects that represent people in the train. 
// The objects are stored in the Train class

public class Person {
	private int trainNumber;
	private String name;
	private String destinationCity;

	// Constructor for a Person object
	public Person(int trainNumber, String name, String destinationCity) {
		this.trainNumber = trainNumber;
		this.destinationCity = destinationCity;
		this.name = name;
	}

	// Getters and setters for the Person class
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the destinationCity
	 */
	public String getDestinationCity() {
		return destinationCity;
	}

	/**
	 * @param destinationCity
	 *            the destinationCity to set
	 */
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	// Hashcode and Equals method for Person class

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destinationCity == null) ? 0 : destinationCity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (destinationCity == null) {
			if (other.destinationCity != null)
				return false;
		} else if (!destinationCity.equals(other.destinationCity))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (trainNumber != other.trainNumber)
			return false;
		return true;
	}

}
