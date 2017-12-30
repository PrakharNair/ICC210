
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class ind5 {

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
		
		boolean isXInt;
		
		do {
			System.out.println("Choose a guess");
			while(!x.hasNextInt()) {
				System.out.println("That is not a number. Try again.");
				x.next();
				isXInt = false;
			}
			temp = x.nextInt();
		} while(isXInt = false);
		return temp;
	}
	
	public static int createNum() {
		int x, y;
		
		boolean isXNum;
		Scanner myScanner = new Scanner(System.in);
		do {
			System.out.println("Choose the maximum number: ");
			while(!myScanner.hasNextInt()) {
				System.out.println("That is not a number. Try again.");
				myScanner.next();
				isXNum = false;
			}
			x = myScanner.nextInt();
		} while(isXNum = false);
		
		
		boolean isYNum; 
		Scanner newScanner = new Scanner(System.in);
		do {
			System.out.println("Choose the minimum number: ");
			while(!newScanner.hasNextInt()) {
				System.out.println("That is not a number. Try again.");
				newScanner.next();
				isYNum = false;
			}
			y = newScanner.nextInt();
		} while(isYNum = false);
		
		if(x < y) {
			System.out.println("Minimum number is larger than the maximum number. Try again:");
			createNum();
		}
		
		int generatedNum = generate(x,y);
		return generatedNum;
	}
	
	public static int userNum() {
		int y;
		
		Scanner userScanner = new Scanner(System.in);
		do {
			System.out.println("How many users will be playing: ");
			while(!userScanner.hasNextInt()) {
				System.out.println("That is not a number. Try again.");
				userScanner.next();
			}
			y = userScanner.nextInt();
		} while(y <= 0);	
		return y; 
	}
	
	public static void game() {
		int n = userNum();
		int temp;
		int bounds; 
		int[] x = new int[n+1];
		int d = 0;
		int a;
		int[] ranking = new int[n+1];
		ArrayList<Integer> wrongAns = new ArrayList<Integer>();
		int[] counter = new int[n];
		int count = 1;
		
		for(int i = 0; i != n; i++) {
			System.out.print("Player " + (i+1) + ": "); 
			//need i+1 so it starts on user1, and ends on user6
			bounds = createNum();
			temp = bounds; 
			x[i] = temp;
		}

		
		for(int i = 0; i != n;) {
			for(int j = 0; j != n;) {				
				if(x[j] == -1) {	
					j++;
				}
				
				else {
					System.out.println("Player " + (j+1) + ": ");
					temp = guess();
					
					if(temp > x[j]) {
						System.out.println("Too high");
						counter[j] = count;
						wrongAns.add(temp);
						j++;
					}
					else if (temp < x[j]) {
						System.out.println("Too Low");
						counter[j] = count;
						wrongAns.add(temp);
						j++;
					}
					else {
						System.out.println("Correct");
						x[j] = -1;
						ranking[i] = j + 1;
						i++;
						counter[j] = count;
					}
				}
			}
			count++;
		}
		System.out.println("Thank you for playing! Rankings:");
		for(int i = 0; i < n; i++) {
			System.out.println((i+1) + ": Player " + ranking[i]);
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println("It took the Player " + (i + 1) + " " + (counter[i]) + " tries to guess properly. ");
		}
		
		System.out.println("Wrong Guesses:");
		System.out.println(wrongAns.toString());
		
		
		int k = 0;
		
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Would you like to play again? (1 = yes/ 2 = no)");
			while(!scan.hasNextInt()) {
				System.out.println("That is not 1 or 2. Try again.");
				scan.next();
			}
			k = scan.nextInt();
		} while(k <= 0);
		
		if(k == 1) {
			game();
		}
		else {
			System.out.println("Exiting now, thanks for playing!");
		}
	}

}
