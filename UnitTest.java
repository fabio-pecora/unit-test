import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class UnitTest {
	Scanner input = new Scanner(System.in);
	ArrayList<String> answers = new ArrayList<String>();
	int numOfAnswers = 0;
	
	//Constructor that reads the file
	public UnitTest() {
		try {
			input = new Scanner(new File("C:\\Users\\franc\\Desktop\\Spring 2022\\Software Design\\Codes\\TestLab\\src\\answers.txt"));		//Open the file and use it as input for our scanner
			//Start reading data from the file
			while (input.hasNext() ) {
				//Until an answer is found, let's add it to the list
				String answer = input.next();
				answers.add(answer);
				// getting the total number of answers
				numOfAnswers++;
			}
		} catch (Exception e) {
			//If we have a problem opening the file we throw this exception 
			System.out.println("Oh no, we have a problem here!");
			e.printStackTrace();  //helps debug			
		}
		//Closing the file
		input.close();
	}
	
	public double calculateGrade(ArrayList<String> studentAnswers) {
		int count = 0;
		//Checking for all the answers with a for loop
		for(int i = 0; i < answers.size(); i++) {
			//Comparing the correct answers with the student's answers, if they are the same then increase the count of 1
			if(answers.get(i).compareTo(studentAnswers.get(i)) == 0) {
				count ++;
			}
		}
		//Returning the total percentage of the correct answers using this formula 
		return count * 100/studentAnswers.size();
	}
}

