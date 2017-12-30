/**
Name: Prakhar NAir
Due Date: 10/29/12017
ITI 201-{Section Number 01 or 02} Introduction to Computer Concepts
Homework: Week 6 {Individual|Team} Assignment 3
Description: Write a loop that prints a 'division grid' showing what numbers (from 1-20) 
across the top are divisible by the number on the left (also from 1-20).  
If the number on the top axis is even, and the grid location below is activated, 
mark that spot with an "E", else mark that location with an "O".
*/

import java.util.Scanner;

public class assign3 {
	
	public static void main(String[] args) {
		System.out.println("Note for the user: due to the nature of this program, the highest input number is"
				+ " 99999. This is because higher numbers would mess up the spacing scheme. ");
		int userInput;
		Scanner myScanner = new Scanner(System.in);
		System.out.print("What is the max number: ");
		userInput = myScanner.nextInt(); 
		
		if(userInput > 99999) {
			System.out.println("The number is larger than 99999.");
			System.exit(1); 
			//This will exit the program
		}
		
		if(userInput == 0) {
			System.out.println("0");
			System.exit(1);
		}
		
		spaces(6); //initial setup
		
		for(int i = 1; i <= userInput; i++) {
			System.out.print(i);
			if(i < 10) {
				spaces(5);
			}
			else if(i < 100) {
				spaces(4);
			}
			else if(i < 1000) {
				spaces(3);
			}
			else if(i < 10000) {
				spaces(2);
			}
			else {
				spaces(1);
			}
		}
			
		for(int i = 1; i <= userInput; i++) {
			System.out.println();
			System.out.print(i);
			spaces(5);
			
			//x acts as a counter
			for(int x = 1; x <= userInput; x++) {
				if(x % i == 0) {
					if (x % 2 == 0) {
						System.out.print("E");
					}
					else {
						System.out.print("O");
					}
					spaces(5);
				}
				else {
					spaces(6);
				}
			}
		}
	}
	
	public static void spaces(int x) {
		
		for(int i = 0; i <= x; i++) {
			System.out.print(" ");
		}
	}
	
	
}
