package pmon;

import java.util.Random;
import java.util.Scanner;

public class pMon {
	String name;
	int hitPoints;
	int attack;
	int defense;
	int specialAttack;
	int specialDefense;
	int speed;
	PMonMove move1;
	PMonMove move2;
	PMonMove move3;
	PMonMove move4;
	
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();

	/**
	 * constructor,  constructs a pMon
	 * @param name
	 * @param baseHP
	 * @param baseAtt
	 * @param baseDef
	 * @param baseSAtt
	 * @param baseSDef
	 * @param speed
	 * @param xp
	 */
	pMon(String name, int baseHP, int baseAtt, int baseDef, int baseSAtt, int baseSDef, int speed, int xp) {
		this.name = name;
		this.attack = baseAtt;
		this.defense = baseDef;
		this.specialAttack = baseSAtt;
		this.specialDefense = baseSDef;
		this.speed = speed;
		this.hitPoints = baseHP;
	}
	/**This method teaches a pMon a move from the PMonMove class, which will have a name, power and accuracy
	 * 
	 * @param beingTaught
	 * @param moveBeingTaught
	 * @param moveSlot
	 */
	public void teachMove(pMon name,PMonMove moveBeingTaught, int moveSlot) {
		switch (moveSlot) {
		case 1:
			name.move1 = moveBeingTaught;
			break;
		case 2:
			name.move2 = moveBeingTaught;
			break;
		case 3:
			name.move3 = moveBeingTaught;
			break;
		case 4:
			name.move4 = moveBeingTaught;
			break;
		}
		System.out.println(this.name+" learnt "+this.move1.name+". \r This move has power: " +moveBeingTaught.power+ " accuracy: "+moveBeingTaught.accuracy);
	}
	
	
	/** Allows user to choose from a list of available moves, the move chosen is returned
	 * 
	 *@return move chosen
	 */
	public PMonMove moveChoice() {
		System.out.println("\r\r\rWhat move would you like to use?");
		if (this.move1!=null) {
				System.out.println("1." + this.move1.name);
		}else if (this.move2!=null) {
				System.out.println("2." + this.move2.name);
		}else if (this.move3!=null) {
				System.out.println("3." + this.move3.name);
		}else if (this.move4!=null) {
				System.out.println("4." + this.move4.name);
		}
		int moveChoice;
		
		moveChoice = scan.nextInt();
		
		switch (moveChoice) {
		case 1:
			System.out.println(this.name+ " uses " +this.move1.name);
			return this.move1;
		}
		return null;
	}
	/**
	 * 
	 * @param bulbasaur
	 */
	private void attack(pMon bulbasaur) {
		
	}
	/**offers the player a choice of pMon
	 * 
	 * @param chosenFighter
	 * @return
	 */
	private static pMon chosenFighter(pMon[] chosenFighter) {
		System.out.println("Choose your fighter: \r 1. Pikachu\r 2. Bulbasaur\r 3. Charmander\r 4. Squirtle");
		int choice = (scan.nextInt())-1;
		System.out.println("You have chosen " +chosenFighter[choice].name);
		return chosenFighter[choice];
	}
	/**
	 * applied on an pMon object, enters a battle with another pMon object
	 * @param opponent
	 */
	private pMon enterBattle(pMon[] list) {
		int f= rand.nextInt(4);
		pMon opponent = list[f-1];
		System.out.println(this.name+" is fighting "+opponent.name);
		return opponent;
	}
	
	
	
	public static void main(String[] args) {
		pMon pikachu = new pMon("Pikachu", 80, 60, 50, 70, 70, 100, 0);
		pMon bulbasaur = new pMon("Bulbasaur", 90, 70, 60, 90, 70, 70, 0);
		pMon charmander = new pMon("Charmander", 90, 70, 50, 70, 50, 90, 0);
		pMon squirtle = new pMon("Squirtle", 100, 60, 100, 70, 90, 80, 0);
		
		PMonMove tackle = new PMonMove("tackle", 35, 95);
		

		pMon[] chosenFighter = {pikachu, bulbasaur, charmander, squirtle};
		
		pMon fighter= chosenFighter(chosenFighter);
		
		fighter.teachMove(fighter,tackle, 1);
		
		fighter.enterBattle(chosenFighter);
		
		fighter.moveChoice();
		
		fighter.attack(bulbasaur);
	}

}
