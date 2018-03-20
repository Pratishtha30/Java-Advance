package Homework5;

import java.util.Arrays;
import java.util.Scanner;

public class SortedStudentApp {
	static Scanner sc = new Scanner(System.in); // get a scanner

	public static void main(String[] args) {
		System.out.println("Welcome to the Student Scores Application.");
		Validator v = new Validator();

		int studentCount = v.getStudentCount();

		Student[] students = new Student[studentCount];
		// get the data for each student and add a Student object to the array
		for (int i = 0; i < studentCount; i++) {
			System.out.println(); // print a blank line
			String lastName = v.getString("Student " + (i + 1) + " last name: ");

			String firstName = v.getString("Student " + (i + 1) + " first name: ");

			int score = v.getScore("Student " + (i + 1) + " score: ");
			students[i] = new Student(lastName, firstName, score);
		}
		// sort the array
		Arrays.sort(students);
		// print the array
		System.out.println();
		for (Student s : students) // for each Student in the array
			System.out.println(s.getSummaryLine());
		System.out.println(); // print the final blank line
	}

}
