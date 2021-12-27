/**
 * 
 */
package pmon2;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

/**
 * @author brienhall
 *
 */
public class Adventure {
	private static final Scanner scan = new Scanner(System.in);

	public void AdventureOptions() {
		System.out.println("choose:" + "\r 1 walk in long grass" + "\r 2 fight the next trainer"
				+ "\r 3 find optional trainer" + "\r 4 backtrack to Pmon centre" + "\r 5 backtrack to shop");
	}

	public int takeInput() {
		int r = scan.nextInt();
		return r;
	}

	public void checkAdventureProgress() {
		File f = new File("adventure.txt");
		try {
			FileReader r = new FileReader(f);
			BufferedReader br = new BufferedReader(r);
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * RNG 1-10
	 * 
	 */
	public int diceRoll() {
		Random r = new Random(10);

		return r.nextInt();
	}

}
