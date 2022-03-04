import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;

public class UnitTestRunner{
	static public void main(String[] args) {
		Scanner line = new Scanner(System.in);
		UnitTest unitTest = new UnitTest();							
		ArrayList<String> answersList = new ArrayList<String>();
		HashMap<String, ArrayList<String>> examMap = new HashMap<String, ArrayList<String>>();
		String fullName;
		String firstName = null;
		String lastName = null;
		String answer = null;
		ArrayList<Double> gradeList = new ArrayList<Double>();
		ArrayList<Student> studentList = new ArrayList<Student>();
		double grade = 0;
		double average = 0;
		double totGrades = 0;
		
		// reading the student information from the file allExams.txt
		try {
			line = new Scanner(new File("C:\\Users\\franc\\Desktop\\Spring 2022\\Software Design\\Codes\\TestLab\\src\\allExams.txt"));
			//Let's start reading data
			while (line.hasNext()){
				
				// reading the lines in three different variables: lastName, firstName, answer
				lastName = line.next();
				firstName = line.next();
				// looping because we have 10 grades for each person
				for(int i = 0; i < unitTest.numOfAnswers; i++) {
					answer = line.next();
					answersList.add(answer);
				}
				// create student objects using last name and first name from the file 
				Student student = new Student(lastName, firstName);
				// add the student to a list of students
				studentList.add(student);
				fullName = (lastName + firstName).toLowerCase();
				// creating an array to store the full names (keys of the map)
				examMap.put(fullName, answersList);
				// re instantiate the ArrayList in order to have 0
				// elements inside of it
				answersList = new ArrayList<String>();
			}
			line.close();		// closing the file
			for(int i = 0; i < studentList.size(); i++) {
				// going through the list of student to get first and last name
				Student myStudent = studentList.get(i);
				// making the right format (lastName followed by firstName all in lower case)
				String myStudentLastName =  studentList.get(i).getLastName().toLowerCase();
				String myStudentFirstName =  studentList.get(i).getFirstName().toLowerCase();
				String myKey = myStudentLastName + myStudentFirstName;
				// get the answers of each student and calculate the grade of each of them
				grade = unitTest.calculateGrade(examMap.get(myKey));
				// adding every grade to a grade list
				gradeList.add(grade);
				// adding all the grades together
				totGrades += grade;
				// computing the average dividing the sum of the grades by
				// the number of student
				average = totGrades / studentList.size();
				myStudent.setAverage(average);
				// printing all students name followed by their grade
				System.out.println(myKey + " " + gradeList.get(i));
			}
		} catch (Exception e) {
			System.out.println("Oh no, we have a problem here!");
			e.printStackTrace();  //helps debug			
		}
	}
}
