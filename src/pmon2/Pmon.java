package pmon2;
public class Pmon {
	
	private int id;
	private String name;
	private String nickName;
	private int hitpoints;
	private int attack;
	private int defense;
	private int speed;
	private String type;
	private int xp;
	
	public Pmon(int id,int hitpoints, int attack, int defense, int speed, String type, String name) {
		this.setId(id);
		this.setName(name);
		this.hitpoints = hitpoints;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.setType(type);
		this.xp = 0;
	}
	
	public void printAll() {
		if (getNickName()!=null)
			System.out.printf("%-2d %-2s\r attack power: %-20d defense: %-20d hitpoints: %-20d speed: %-20d", getId(), getNickName(), getAttack(),getDefense(), getHitpoints(), getSpeed());
		else
			System.out.printf("%-2d %-2s \t\t attack power: %-20d defense: %-20d hitpoints: %-20d speed: %-20d", getId(), getName(), getAttack(),getDefense(), getHitpoints(), getSpeed());
			
	}


	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}


	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	/**
	 * @return the hitpoints
	 */
	public int getHitpoints() {
		return hitpoints;
	}


	/**
	 * @param hitpoints the hitpoints to set
	 */
	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}


	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}


	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}


	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}


	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}


	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}


	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}


	

	


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
