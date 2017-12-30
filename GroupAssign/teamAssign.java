/* Team Assignment: Team Golf
 * DISCLAIMER:
 * For the program to run properly, you must change the path on the file readers
 * on lines 33 and 193.
 * Otherwise it will not run.
 * 
 */

package teamasssign;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class teamAssign {

	public static void main(String[] args) throws FileNotFoundException {

		BufferedReader reader = null;
			ArrayList <String> FavoriteSongs = new ArrayList <String>();
			ArrayList<String> newSongList = new ArrayList<String>();
			ArrayList<String> comments = new ArrayList<String>();
			
			try {

				String sCurrentLine;

				reader = new BufferedReader(new FileReader("/Users/Prakhar/Documents/FavoriteSongs.txt"));

				
				while ((sCurrentLine = reader.readLine()) != null) {
					FavoriteSongs.add(sCurrentLine);
				}

				System.out.println("Favorite Songs:" + FavoriteSongs);
				AddElement(FavoriteSongs);
				System.out.println("Favorite Songs:" + FavoriteSongs);
				DeleteElement(FavoriteSongs);
				
				
					for (int x= 0; x < FavoriteSongs.size() ; x++ ) {
						System.out.println(FavoriteSongs.get(x));
					}
					
			} catch (IOException e) {
				e.printStackTrace();
				System.out.print(e.getMessage());
			} finally {
				try {

					if (reader != null)reader.close();
				} catch (IOException ex) {
					System.out.println(ex.getMessage());
					ex.printStackTrace();

				}
			}
			
			ArrayList<Integer> ranks = new ArrayList<Integer>();
			//create an array
						
			int rank = 0; 
			
			for(int i = 0; i < FavoriteSongs.size(); i++) {	
				Scanner x = new Scanner(System.in);
				System.out.println("Where would you like to rank the song: " + FavoriteSongs.get(i));
				while(true) {
					if(!x.hasNextInt()) {
						System.out.println("That is not a number. Try again.");
						x.nextLine();
					}
					else {
						rank = x.nextInt();
						if(rank > FavoriteSongs.size()) {
							System.out.println("Unreasonable rank");
						}
						else {
							break;
						}
					}
				}
			
				rank = rank - 1; 
				//makes calculations 100x easier
				
				
				if(ranks.size() == 0) {
					ranks.add(rank);
					System.out.println("Rank available!");
				}//to ensure the array is made at least. 
				
				else if(ranks.contains(rank) == true) {
					System.out.println("Something already exists at this rank. Pushing everything at this rank and below down 1, to accomodate.");
					ranks.add(rank);
				}//if rank is given, regardless of position this will signal that the ranking will be repositioned
				
				else {
					ranks.add(rank);
					System.out.println("Rank available!");
				}//rank was not guessed yet
				
				Scanner y = new Scanner(System.in);
				//need new scanner to call nextLine
				while(true) {
					//loop will never end until it is broken
					System.out.println("Would you like to add any comments? (yes/no)");
		
					String tp = x.next();
					if(tp.equals("yes")) {
						System.out.println("Add Comments: " );
						comments.add(y.nextLine());
						break;
						//adds comments to the comment array
					}
					else if(tp.equals("no")) {
						System.out.println("No Comments added");
						comments.add("No Comments");
						break;
						//adds no comments
					}
					else {
						System.out.println("Not a valid input. Please use lower case letters and try again");
					}//in case user messes up
				} 
			}			
			//System.out.println(ranks);
			
			int minDex;
			//index for the lowest rank
			
			ArrayList<String> tempList = new ArrayList<String>();
			ArrayList<String> theComments = new ArrayList<String>();
			
			tempList.addAll(FavoriteSongs);
			//System.out.println("This is temp:" + tempList);
			
			Collections.reverse(ranks);
			Collections.reverse(tempList);
			Collections.reverse(comments);
			/* This was by far the trickiest part of the algorithm.
			 * At first, the ordering was correct for the most part.
			 * There were errors with duplicate rankings, making the entry that was supposed to be 
			 * pushed back, not being pushed back, rather the original ranking to be pushed back
			 * By reversing the arraylists, it ensures proper behavior of the algorithm, and allows for 
			 * proper behavior of any scenario.
			 */
			
			
			for(int i = FavoriteSongs.size() - 1; i != 0; i--) {
				minDex = ranks.indexOf(Collections.min(ranks));
				//looks for min number
				//System.out.println(minDex);
				
				newSongList.add(tempList.get(minDex));
				//adds the lowest ranking song to front of the list
				theComments.add(comments.get(minDex));
				//adds comments of lowest ranking song to front of the list
				
				tempList.remove(minDex);
				comments.remove(minDex);
				//removes the comments and song from the list 
				
				ranks.remove(Collections.min(ranks));
				//removes the rank from the song
				
				//System.out.println(ranks);
				//System.out.println(tempList);
			}
			newSongList.add(tempList.get(0));
			theComments.add(comments.get(0));
			//need to add this because the arrays the new arrays are misisng 1 element, and the 
			//original arrays still hold the last element.
			//quick fix type of thing
			
			/* System.out.println(newSongList);
			System.out.println(theComments); */
			
			ArrayList<String> finalList = new ArrayList<String>();
			
			for(int i = 0; i < FavoriteSongs.size(); i++) {
				finalList.add(newSongList.get(i) + " | " + " Rank: " + (i+1) + " | Comments: " + theComments.get(i));
			}// prints the order

			
			PrintWriter writer = new PrintWriter(new File("/Users/Prakhar/Documents/FavoriteSongs.txt"));
			System.out.println("\nFinal favorite list\n");
			for(String string: finalList)
			{
				writer.write(string + "\n");
				System.out.println(string);
			}
			writer.close();
			
			
	}
	
	public static void AddElement (ArrayList s) {
		String temp = "";
		String input = "";
		boolean again = true;
		Scanner x = new Scanner(System.in);
		while (again == true) {
			System.out.println("Would you like to add an element? Type yes or no.");
			input = x.nextLine();
				if (input.equals("yes")) {
					System.out.println("Write the name of the element you would like to add: ");
					temp = x.nextLine();
					s.add(temp);
					System.out.println(temp + " has been added to your list.");
				}
				else if (input.equals("no")) {
					again = false;
				}
				else {
					System.out.println("That is not a valid input. Please enter yes or no.");
				}
		}
	}

	public static void DeleteElement (ArrayList s) {
		String temp = "";
		String input = "";
		boolean again = true;
		boolean numberError = false;
		int tempnumber = 0;
		
		Scanner x = new Scanner(System.in);
		while (again == true) {
			System.out.println("Would you like to delete an element? Type yes or no.");
			input = x.next();
			System.out.println(input);
				if (input.equals("yes")) {
					System.out.println("Which number element would you like to delete?");
					do {
						try {
							temp = x.next();
							tempnumber = Integer.parseInt(temp.trim()); 
							numberError = false; 
						} catch(Exception e) {
							System.out.println("Your entry: \"" + temp+ "\" is invalid! Please try again.");
							numberError = true; 
						}
						if (tempnumber > s.size() || tempnumber < 1) {
							System.out.println("That is not a valid number in the range of the list.");
							numberError = true;
						}
					} while (numberError == true );  
					
							s.remove(tempnumber-1);
							System.out.println("Element number " + tempnumber + " has been removed from the list.");
							System.out.println(s);
				}
				else if (input.equals("no")) {
					again = false;
				}
				else {
					System.out.println("That is not a valid input. Please enter yes or no.");
				}
		}
	}
	
}
