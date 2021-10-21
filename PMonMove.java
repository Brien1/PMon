package pmon;

public class PMonMove {
	public String name;
	public int power;
	public int accuracy;
	public String statusEffect;
	public String type;
	public int isSpecial;
	
	
	/** Constructs an attack/ move that can be learnt
	 * 
	 * @param name - the name of the attack
	 * @param power - the strength of the attack, 10 is weak, 100 is strong
	 * @param accuracy - accuracy 95 is good, 60 is low
	 */
		public PMonMove(String name, int power, int accuracy, String type, int isSpecial){
			this.name = name;
			this.power = power;
			this.accuracy = accuracy;
			this.type = type;
			this.isSpecial = isSpecial;

		}
	
			
		}
	
	
	
	


