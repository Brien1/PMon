package pmon2;

import java.util.ArrayList;

public class Trainer {

	private ArrayList<String> dialogue = new ArrayList<>();
	private String name;
	private Pmon p1;
	private Pmon p2;
	private Pmon p3;
	private Pmon p4;
	/** Constructing a pmon trainer with 4 pmon
	 * @param dialogue
	 * @param name
	 * @param one
	 * @param two
	 * @param three
	 * @param four
	 */
	public Trainer(ArrayList<String> dialogue, String name, Pmon one, Pmon two, Pmon three, Pmon four) {
		this.dialogue = dialogue;
		this.name = name;
		this.p1 = one;
		this.p2 = two;
		this.p3 = three;
		this.p4 = four;
	}
	/**
	 * Constructing a pmon trainer with 3 pmon
	 * @param rmDia
	 * @param name2
	 * @param one
	 * @param two
	 * @param three
	 */
	public Trainer(ArrayList<String> rmDia, String name2, Pmon one, Pmon two, Pmon three) {
		this.dialogue = rmDia;
		this.name = name2;
		this.p1 = one;
		this.p2 = two;
		this.p3 = three;
	}
	/**
	 * constructing a pmon trainer with 2 pmon
	 * @param rmDia
	 * @param name2
	 * @param one
	 * @param two
	 */
	public Trainer(ArrayList<String> rmDia, String name2, Pmon one, Pmon two) {
		// TODO Auto-generated constructor stub
		this.dialogue = rmDia;
		this.name = name2;
		this.p1 = one;
		this.p2 = two;
	}
	/**
	 * constructing a pmon trainer with one pmon
	 * @param rmDia
	 * @param name2
	 * @param one
	 */
	public Trainer(ArrayList<String> rmDia, String name2, Pmon one) {
		this.dialogue = rmDia;
		this.name = name2;
		this.p1 = one;	}
	@Override
	public String toString() {
		String _return = "";
		_return += "name: "+this.name;
		_return += " dialgoue: "+this.dialogue;
		_return += " Pmon1: "+this.p1.getName();
		if (this.p2!=null) {
			_return += " Pmon2: "+this.p2.getName();}
		if (this.p3!=null) {
			_return += " Pmon3: "+this.p3.getName();}
		if (this.p4!=null) {
			_return += " Pmon4: "+this.p4.getName();}
				
		
		
		
		return _return;

	}
	/**
	 * @return the dialogue
	 */
	public ArrayList<String> getDialogue() {
		return dialogue;
	}
	/**
	 * @param dialogue the dialogue to set
	 */
	public void setDialogue(ArrayList<String> dialogue) {
		this.dialogue = dialogue;
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
	 * @return the p1
	 */
	public Pmon getP1() {
		return p1;
	}
	/**
	 * @param p1 the p1 to set
	 */
	public void setP1(Pmon p1) {
		this.p1 = p1;
	}
	/**
	 * @return the p2
	 */
	public Pmon getP2() {
		return p2;
	}
	/**
	 * @param p2 the p2 to set
	 */
	public void setP2(Pmon p2) {
		this.p2 = p2;
	}
	/**
	 * @return the p3
	 */
	public Pmon getP3() {
		return p3;
	}
	/**
	 * @param p3 the p3 to set
	 */
	public void setP3(Pmon p3) {
		this.p3 = p3;
	}
	/**
	 * @return the p4
	 */
	public Pmon getP4() {
		return p4;
	}
	/**
	 * @param p4 the p4 to set
	 */
	public void setP4(Pmon p4) {
		this.p4 = p4;
	}
	
	
	
	
}
