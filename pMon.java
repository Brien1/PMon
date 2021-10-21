package pmon;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class pMon {
	String name;
	int hitPoints;
	int attack;
	int defence;
	int specialAttack;
	int specialDefence;
	int speed;
	String type;
	PMonMove move1;
	PMonMove move2;
	PMonMove move3;
	PMonMove move4;
	
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	public static String[][] typeStr= 
	{{"e", "electric", "water", "grass", "fire"},
	 {"electric", "weak", "strong", "e", "e"},
	 {"water", "e", "weak", "weak", "strong"},
	 {"grass", "e", "strong", "weak", "weak"},
	 {"fire", "e", "weak", "strong", "weak"}};
		
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
	pMon(String name, int baseHP, int baseAtt, int baseDef, int baseSAtt, int baseSDef, int speed, int xp, String type) {
		this.name = name;
		this.attack = baseAtt;
		this.defence = baseDef;
		this.specialAttack = baseSAtt;
		this.specialDefence = baseSDef;
		this.speed = speed;
		this.hitPoints = baseHP;
		this.type = type;
	}
	/**This method teaches a pMon a move from the PMonMove class, which will have a name, power and accuracy
	 * 
	 * @param beingTaught
	 * @param moveBeingTaught
	 * @param moveSlot
	 */
	public void teachMove(pMon name,PMonMove moveBeingTaught, int moveSlot) {
		System.out.println(name.name+" wants to learn "+moveBeingTaught.name);
		switch (moveSlot) {
		case 1:
			if (moveBeingTaught.type==null) {
				
				name.move1 = moveBeingTaught;
				System.out.println(this.name+" learnt "+this.move1.name+". \r This move has power: " +moveBeingTaught.power+ " accuracy: "+moveBeingTaught.accuracy);
				break;}
			if (moveBeingTaught.type.equals(this.type)) {
				name.move1 = moveBeingTaught;
				System.out.println(this.name+" learnt "+this.move1.name+". \r This move has power: " +moveBeingTaught.power+ " accuracy: "+moveBeingTaught.accuracy);
			} else {
				System.out.println("Type mismatch");
			}
			break;
		case 2:
			if (moveBeingTaught.type==null) {
				name.move2 = moveBeingTaught;
				System.out.println(this.name+" learnt "+this.move2.name+". \r This move has power: " +moveBeingTaught.power+ " accuracy: "+moveBeingTaught.accuracy);
				break;}
			if (moveBeingTaught.type.equals(this.type)) {
				name.move2 = moveBeingTaught;
				System.out.println(this.name+" learnt "+this.move2.name+". \r This move has power: " +moveBeingTaught.power+ " accuracy: "+moveBeingTaught.accuracy);
			} else {
				System.out.println("Type mismatch");
			}
			break;
		case 3:
			if (moveBeingTaught.type.equals(this.type)) {
				
				name.move3 = moveBeingTaught;
				System.out.println(this.name+" learnt "+this.move3.name+". \r This move has power: " +moveBeingTaught.power+ " accuracy: "+moveBeingTaught.accuracy);
			} else {
				System.out.println("Type mismatch");
			}
			break;
		case 4:
			if (moveBeingTaught.type.equals(this.type)) {
				
				name.move4 = moveBeingTaught;
				System.out.println(this.name+" learnt "+this.move4.name+". \r This move has power: " +moveBeingTaught.power+ " accuracy: "+moveBeingTaught.accuracy);
			} else {
				System.out.println("Type mismatch");
			}
			break;
		}
	
	}
	
	
	/** Allows user to choose from a list of available moves, the move chosen is returned
	 * 
	 *@return move chosen
	 */
	public PMonMove moveChoice() {
		System.out.println("\r\r\rWhat move would you like to use?");
		if (this.move1!=null) {
				System.out.println("1." + this.move1.name);
		} if (this.move2!=null) {
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
			return this.move1;
		case 2:
			return this.move2;
		case 3:
			return this.move3;
		case 4:
			return this.move4;
		}
		return null;
	}
	/**Non static method for a PMon.       Does speed check.     calls fighters/ opponents attack method which does accuracy roll and damage hit
	 * 
	 * @param opponent
	 * @param move choice
	 */
	private void attack(pMon opponent, PMonMove choice) {
		// who hits first
		if (this.speed>=opponent.speed) { ///////// speed check
		//hit chance
			fighterAttemptsAttack(this, choice, opponent);
			
			opponentAttemptsAttack(this,opponent);
		}//end of fighter going first
		
		else { //////// speed check failed
			opponentAttemptsAttack(this,opponent);

			fighterAttemptsAttack(this, choice, opponent);

			
		}	
	}
	/**
	 * opponent attacks, calls opponentMoveSelection(), does accuracy roll, damage roll, modifies stats of fighter (lowers hp)
	 * @param pMon player controlled
	 * @param choice 
	 * @param opponent
	 */
	private void opponentAttemptsAttack(pMon pMon, pMon opponent) {
		if(opponent.hitPoints>0) {
			//opponent chooses a move
			PMonMove attackingWithThisMove = opponentMoveSelection(opponent);
			if (rand.nextInt(100)<attackingWithThisMove.accuracy) {

			System.out.println(opponent.name+" uses " +attackingWithThisMove.name+ ", " +opponent.name+ " hits "+this.name);
			this.hitPoints = this.hitPoints 
					- attackingWithThisMove.power 
					+ rand.nextInt(10) 
					- isEffective(attackingWithThisMove.type, pMon.type) 
					- statBasedDamageModifier(opponent, attackingWithThisMove, pMon);  // rand.nextInt introduces slightly stronger and weaker attacks --- but i want to involve att,def,satt,sdef and type still
			System.out.println(this.name+ " hitpoints drops to "+this.hitPoints);}

			else {System.out.println(opponent.name+" misses " + this.name);}
	}
	}
	/**runs randomiser to select move for computer controlled enemy
	 * 
	 * @param opponent
	 */
	private PMonMove opponentMoveSelection(pMon opponent) {
		ArrayList <PMonMove> moves = new ArrayList<PMonMove>();
		if (opponent.move1!=null) {
			moves.add(opponent.move1);
		}
		if (opponent.move2!=null) {
			moves.add(opponent.move2);
		}
		if (opponent.move3!=null) {
			moves.add(opponent.move3);
		}
		if (opponent.move4!=null) {
			moves.add(opponent.move4);
		}
		
		int randomisedNumber = rand.nextInt(moves.size());
		PMonMove selected = moves.get(randomisedNumber);
		return selected;
	}
	/**
	 * fighter attacks, accuracy roll, damage roll, modifies stats of opponent
	 * @param pMon
	 * @param choice
	 * @param opponent
	 */
	private void fighterAttemptsAttack(pMon pMon, PMonMove choice, pMon opponent) {
		if(this.hitPoints>0) {
			if (rand.nextInt(100)<choice.accuracy) {
				System.out.println(this.name+" uses " +choice.name+ ", " +this.name+ " hits "+opponent.name);
				opponent.hitPoints = opponent.hitPoints 
						- choice.power 
						+ rand.nextInt(10) 
						- isEffective(choice.type, opponent.type) 
						- statBasedDamageModifier(pMon, choice, opponent);
				System.out.println(opponent.name+ " hitpoints drops to "+opponent.hitPoints);}
			
			else {System.out.println(this.name+" misses "+opponent.name);}
	}
	}
	/**
	 * accesses the move type as special or not,  modifies it based on specialAttack or attack,  does another modification based on opponents specialDefence or defence as is relivent
	 * @param pMon
	 * @param choice
	 * @param opponent
	 * @return
	 */
	private int statBasedDamageModifier(pMon pMon, PMonMove choice, pMon opponent) {
		if (choice.isSpecial==0) { //i.e. it is NOT special
			int damageToBeReturned = pMon.attack - opponent.defence;
			return damageToBeReturned;		
		}
		if (choice.isSpecial==1) { //i.e. it IS special
			int damageToBeReturned = pMon.specialAttack - opponent.specialDefence;
			return damageToBeReturned;		

		}
		return 0;
	}
	/**Checks the move type against pMon type (the move is being used on this pMon), to determine if it is super effective, or weak.
	 * if it is super effective it return Int 20, which can be added to a damage calculation
	 * if it is weak it will return -20
	 * if it is neither it will return 0
	 * @param moveType
	 * @param opponentType
	 * @return damage bonus
	 */
	private static int isEffective(String moveType, String opponentType) {
		
		int comparitiveColumn=0;
		int comparitiveRow =0;
		
		for (int x=0; x<typeStr.length; x++) {
			if (x==0) {
				for (int y =0; y < typeStr[0].length; y++) {
					if (typeStr[0][y].equals(opponentType)) {
						comparitiveColumn = y;
					}
				}}
			if (x>=1 && typeStr[x][0].equals(moveType)) {
				comparitiveRow = x;
			}
				for (int y =0; y < typeStr.length; y++) {
				
			}
		}
		if (typeStr[comparitiveRow][comparitiveColumn].equals("strong")) {
			System.out.println("it's super effective!");
			return 20;}
		if (typeStr[comparitiveRow][comparitiveColumn].equals("weak")) {
			System.out.println("it's not very effective....");
			return -20;}
		return 0;
		
	}
	
	/**offers the player a choice of pMon,  scanner reads choice,
	 * 
	 * @param availableFighters, list of available pMon
	 * @return a single chosen pMon
	 */
	private static pMon chosenFighter(pMon[] availableFighters) {
		System.out.println("Choose your fighter: \r 1. Pikachu\r 2. Bulbasaur\r 3. Charmander\r 4. Squirtle");
		int choice = (scan.nextInt())-1;
		System.out.println("You have chosen " +availableFighters[choice].name);
		return availableFighters[choice];
	}
	/**
	 * applied on an pMon object, enters a battle with another pMon object
	 * @param opponent
	 */
	private pMon enterBattle(pMon[] list) {
		int f= rand.nextInt(3);
		pMon opponent = list[f];
		System.out.println("\n\n"+this.name+" is fighting "+opponent.name);
		return opponent;
	}
	/**
	 * simply prints a message of the name of fainted pMon
	 */
	private void collapseMessage() {
		System.out.println(this.name+ " faints");
	}
	/**
	 * checks who of the two opponents is still alive
	 * @param fighter
	 * @param opponent
	 * @return
	 */
	private static boolean winnerCheck(pMon fighter, pMon opponent) {
		if(fighter.hitPoints<=0) {
			fighter.collapseMessage();
			return true;}
		if (opponent.hitPoints<=0) {
			opponent.collapseMessage();
			return true;}
		return false;
	}
	
	
	public static void main(String[] args) {
		//pMon something = new pMon(name, hp, at, def, sat,sdf, spd, xp, type
		pMon pikachu = new pMon("Pikachu", 115, 60, 50, 70, 70, 100, 0, "electric");
		pMon bulbasaur = new pMon("Bulbasaur", 115, 70, 60, 90, 70, 70, 0, "grass");
		pMon charmander = new pMon("Charmander", 115, 70, 50, 70, 50, 90, 0, "fire");
		pMon squirtle = new pMon("Squirtle", 125, 60, 100, 70, 90, 80, 0, "water");
		//PmonMove class NAME = new PMonMove (name, power, accuracy, type, 0=not special 1 = special
		PMonMove tackle = new PMonMove("tackle", 35, 95, null, 0);
		PMonMove electricShock = new PMonMove("electric shock", 45, 90, "electric",1);
		PMonMove ember = new PMonMove("ember", 45, 90, "fire",1);
		
		pMon[] chosenFighter = {pikachu, bulbasaur, charmander, squirtle};
		
		pMon fighter= chosenFighter(chosenFighter);
		
		fighter.teachMove(fighter,tackle, 1);
		fighter.teachMove(fighter, electricShock, 2);
		
		pMon opponent = charmander;//														fighter.enterBattle(chosenFighter);
		opponent.teachMove(opponent, tackle, 1);
		opponent.teachMove(opponent, ember, 2);
		
		do {
		fighter.attack(opponent, fighter.moveChoice());
		if (winnerCheck(fighter, opponent))
			break;

		} while (opponent.hitPoints>0||fighter.hitPoints>0);
		
	}


}
