public class Student {
	private String lastName;
	private String firstName;
	private double average;
	
	//Getters
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public double getAverage() {
		return average;
	}
	
	//Setters
	public void setAverage(double average) {
		this.average = average;
	}
	
	//Constructors
	public Student(){
		lastName = "Pecora";
		firstName = "Fabio";
		average = 3.7;
	}
	
	public Student(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.average = 0;
	}
}
