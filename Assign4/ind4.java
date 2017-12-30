/**
Name: Prakhar Nair
Due Date: 11/05/12017
ITI 201-{Section Number 01 or 02} Introduction to Computer Concepts
Homework: Week 8 {Individual} Assignment 4
Description: Write a new program that will
•Pick a Random Number 
•Collect an (integer)  guess from the user 
Be sure to verify that the input is legitimate!!
•Compare the guess to the random number
•Output if the guess is “Too High!”, “Too Low!”, “Right!”
Repeat until the user gets the answer correct 
Once the user guesses the correct value, ask them if they wish to play again…
If Yes, reset the ‘mystery’ number and play again.
**/

import java.util.Random;
import java.util.Scanner;

public class ind4 {

	public static void main(String[] args) {
		game();
	}
	
	public static int generate(int a, int b) {
		int range = (a - b) + 1;
		int x = (int)(Math.random() * range) + b;
		return x;
	}
	
	public static int guess() {
		int temp;
		Scanner x = new Scanner(System.in);
		
		do {
			System.out.println("Choose a guess");
			while(!x.hasNextInt()) {
				System.out.println("That is not a number. Try again.");
				x.next();
			}
			temp = x.nextInt();
		} while(temp <= 0);
		return temp;
	}
	
	public static void game() {	
		int userInput1;
		int userInput2;	
		boolean replay;
		
		Scanner myScanner = new Scanner(System.in);
		do {
			System.out.println("Choose the maximum number");
			while(!myScanner.hasNextInt()) {
				System.out.println("That is not a number. Try again.");
				myScanner.next();
			}
			userInput1 = myScanner.nextInt();
		} while(userInput1 <= 0);
		
		
		Scanner newScanner = new Scanner(System.in);
		do {
			System.out.println("Choose the minimum number");
			while(!newScanner.hasNextInt()) {
				System.out.println("That is not a number. Try again.");
				newScanner.next();
			}
			userInput2 = newScanner.nextInt();
		} while(userInput2 <= 0);
		
		int y = generate(userInput1, userInput2);

		Scanner sc = new Scanner(System.in);
		int userGuess = guess();
		
		int d = 0; 
		int a;
		
		do {
			if(userGuess > y) {
				System.out.println("Too high");
				userGuess = guess();
			}
			else if(userGuess < y) {
				System.out.println("Too low");
				userGuess = guess();
			}
			else {
				d = 1;
				Scanner scan = new Scanner(System.in);
				do {
					System.out.println("Right! Would you like to play again? (1 = yes/ 2 = no)");
					while(!scan.hasNextInt()) {
						System.out.println("That is not a number. Try again.");
						scan.next();
					}
					a = scan.nextInt();
				} while(a <= 0);
				
				if(a == 1) {
					game();
				}
				else {
					break;
				}
			}
		}while(d == 0); 
	}
	
	
}
