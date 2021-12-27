/**
 * 
 */
package pmon2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.text.GapContent;

/**
 * @author brienhall
 *
 */
public class PmonFactory {
	// a list of all the trainers in the game (not the player)
	private static final ArrayList<Trainer> trainerList = new ArrayList<Trainer>();
	// a list of all the Pmon with base stats,  should be copied from can not be altered.
	private static final ArrayList<Pmon> pmonList = new ArrayList<Pmon>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		/* Creating a new file that looks at pmon.txt
		 * Then creating an ArrayList that will store all the Pmon for referenced when creating a new occurence
		 * of a particular Pmon in the future,  such as assigning it to a trainer or the player catching this 
		 * particular Pmon.   
		 */
		File pmon = new File("pmon.txt");
		FileReader read;
		try {
			BufferedReader r = 
					/*The method call here will create populate the Pmon list.
					 * 
					 */
					readInPmon(pmon, pmonList);

			
			
			readInTrainers(pmonList);

			
			Adventure a = new Adventure();
			while (true) {
				
				
				
				a.AdventureOptions();
				a.takeInput();
				a.checkAdventureProgress();
				
				
				
				boolean somethingHappens = false;
				if (somethingHappens )
					break;
				
			}
			
			
			
			
			
			
			
			
			r.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // end main method

	/**
	 * @param pmon
	 * @param Pmon
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static BufferedReader readInPmon(File pmon, ArrayList<Pmon> Pmon)
			throws FileNotFoundException, IOException {
		FileReader read;
		read = new FileReader(pmon);
		BufferedReader r = new BufferedReader(read);

		String line = r.readLine();
		int pmonID = 0;
		do {
			pmonID++;
			String[] incomingData = line.split(" ");
			Pmon.add(new Pmon(pmonID, Integer.parseInt(incomingData[2]), Integer.parseInt(incomingData[3]),
					Integer.parseInt(incomingData[4]), Integer.parseInt(incomingData[5]), incomingData[1],
					incomingData[0]));
			line = r.readLine();
		} while (line != null);

//		for (Pmon p : Pmon) {
//			p.printAll();
//			System.out.println();
//		}
		return r;
	}
	/**
	 * Takes the list of Pmon and creates a list of trainers
	 * @param Pmon
	 * @return 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static ArrayList<Trainer> readInTrainers(ArrayList<Pmon> Pmon)
			throws FileNotFoundException, IOException {
		String line;
		File trainer = new File("trainer.txt");
		FileReader reader = new FileReader(trainer);
		BufferedReader rt = new BufferedReader(reader);

		line = rt.readLine();
		do {
			ArrayList<String> rmDia = new ArrayList<String>();
			String[] sa1 = line.split("-"); // now sa1[1] is the dialogue which is being separated by ","
			String[] sa2 = sa1[1].split(","); // now sa2 is a stringArray where the number of elements is the number
												// of possible dialogues.
			for (int i = 0; i < sa2.length; i++) {
				rmDia.add(sa2[i]);
			}

			String[] nameAndPmon = sa1[0].split(" ");
			String name = nameAndPmon[0];

			int pmonOne = Integer.parseInt(nameAndPmon[1]);
			int pmonTwo = 0;
			int pmonThree = 0;
			int pmonFour = 0;
			if (nameAndPmon.length > 2) {
				pmonTwo = Integer.parseInt(nameAndPmon[2]);
			}
			if (nameAndPmon.length > 3) {
				pmonThree = Integer.parseInt(nameAndPmon[3]);
			}
			if (nameAndPmon.length > 4) {
				pmonFour = Integer.parseInt(nameAndPmon[4]);
			}

			Pmon one = null;
			Pmon two = null;
			Pmon three = null;
			Pmon four = null;
			for (Pmon p : Pmon) {
				if (p.getId() == pmonOne) {
					one = new Pmon(p.getId(), p.getHitpoints(), p.getAttack(), p.getDefense(), p.getSpeed(),
							p.getType(), p.getName());
				}
				if (p.getId() == pmonTwo && pmonTwo != 0) {
					two = new Pmon(p.getId(), p.getHitpoints(), p.getAttack(), p.getDefense(), p.getSpeed(),
							p.getType(), p.getName());
				}
				if (p.getId() == pmonThree && pmonThree != 0) {
					three = new Pmon(p.getId(), p.getHitpoints(), p.getAttack(), p.getDefense(), p.getSpeed(),
							p.getType(), p.getName());
				}
				if (p.getId() == pmonFour && pmonFour != 0) {
					four = new Pmon(p.getId(), p.getHitpoints(), p.getAttack(), p.getDefense(), p.getSpeed(),
							p.getType(), p.getName());
				}
			}

			switch (nameAndPmon.length) {
			case 2: {

				trainerList.add(new Trainer(rmDia, name, one));
				break;
			}
			case 3: {

				trainerList.add(new Trainer(rmDia, name, one, two));
				break;
			}
			case 4: {

				trainerList.add(new Trainer(rmDia, name, one, two, three));
				break;

			}
			case 5: {

				trainerList.add(new Trainer(rmDia, name, one, two, three, four));
				break;

			}

			}

			line = rt.readLine();
		} while (line != null);

//		for (Trainer trainer2 : trainerList) {
//			System.out.println(trainer2.toString());
//		}
		rt.close();
		return trainerList;
		
	}

}
