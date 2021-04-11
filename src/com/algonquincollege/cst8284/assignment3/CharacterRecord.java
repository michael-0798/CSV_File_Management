/*
 * Assessment: CST8284 Assignment 03 (21W)
 * Modified by Student: Michael Wang
 * Lab Section: 314
 * Lab Professor: Leanne Seaward
 */

package com.algonquincollege.cst8284.assignment3;
/**
 * <p>This class contains the data for a CharacterRecord. The fields have
 * basic data validation in each of the mutator methods (setters).</p>
 * - Every set method validates the data passed into it.
 * 
 *   - throws an IllegalArgumentException with a message containing
 *     the field name, and reason for the exception being thrown.
 *     
 *   - None of the String fields should be set with text containing a comma
 *     character e.g. ','
 *     
 *   - The field named "name" cannot exceed 50 characters in length.
 *     (The other String fields do not have any limits to length.)
 *     
 *   - attackChance1, and attackChance2 cannot be negative, cannot exceed
 *     100. 
 *     Note: The sum of attackChance1 and attackChance2 can exceed 100,
 *     but each separate field cannot.
 */
public class CharacterRecord {
	/** contains the name of the character */
	private String name;
	
	/** contains a description of how health is calculated */
	private String health;
	
	/** contains a description of how strength is calculated */
	private String strength;
	
	/** contains a description of how attack damage is calculated */
	private String attackDamage;
	
	/** contains the percent chance for attack1 to be generated */
	private int attackChance1;
	
	/** contains the percent chance for attack2 to be generated */
	private int attackChance2;
	
	/** contains the name of the type of attack1 */
	private String attackType1;
	
	/** contains the name of the type of attack2 */
	private String attackType2;
	
	/** contains a description of how this character defends from attack */
	private String defense;

	/**
	 * The no parameter constructor does not set any values.
	 */
	public CharacterRecord() {
		super();
	}
	
	/**
	 * Returns the name field
	 * @return the name field
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name field with the value passed
	 * will throw IllegalArgumentsException if the parameter is over 50 chars
	 * @param name a reference to a String for name field
	 */
	public void setName(String name) {
		if(name.length()<=50 && name.length()>0) {
			this.name = name;
		}else {
			System.out.println("name cannot exceed 50 letters");
			throw new IllegalArgumentException("name cannot exceed 50 letters");
		}
	}

	/**
	 * Returns the health field
	 * @return the health field
	 */
	public String getHealth() {
		return health;
	}

	/**
	 * Changes the health field with the value passed
	 * will throw IllegalArgumentsException if the parameter is not a String
	 * @param health name a reference to a String for health field
	 */
	public void setHealth(String health) {
		this.health = health;
	}

	/**
	 * Returns the strength field
	 * @return the strength field
	 */
	public String getStrength() {
		return strength;
	}

	/**
	 * Changes the strength field with the value passed
	 * will throw IllegalArgumentsException if the parameter is not a String
	 * @param strength name a reference to a String for strength field
	 */
	public void setStrength(String strength) {
		this.strength = strength;
	}

	/**
	 * Returns the attackDamage field
	 * @return the attackDamage field
	 */
	public String getAttackDamage() {
		return attackDamage;
	}

	/**
	 * Changes the attackDamage field with the value passed
	 * will throw IllegalArgumentsException if the parameter is not a String
	 * @param attackDamage name a reference to a String for attackDamage field
	 */
	public void setAttackDamage(String attackDamage) {
		this.attackDamage = attackDamage;
	}

	/**
	 * Returns the attackChance1 field
	 * @return the attackChance1 field
	 */
	public int getAttackChance1() {
		return attackChance1;
	}

	/**
	 * Changes the attackChance1 field with the value passed
	 * will throw IllegalArgumentsException if the parameter is negative or over 100
	 * @param attackChance1 name an integer for attackChance1
	 */
	public void setAttackChance1(int attackChance1) {
		if (attackChance1 >=0 && attackChance1<=100) {
			this.attackChance1 = attackChance1;
		}else {
			System.out.println("attackChance1 can not be negative or over 100");
			throw new IllegalArgumentException("attackChance1 can not be negative or over 100");
		}
	}

	/**
	 * Returns the attackChance2 field
	 * @return the attackChance2 field
	 */
	public int getAttackChance2() {
		return attackChance2;
	}

	/**
	 * Changes the attackChance2 field with the value passed
	 * will throw IllegalArgumentsException if the parameter is negative or over 100
	 * @param attackChance2 name an integer for attackChance2
	 */
	public void setAttackChance2(int attackChance2) {
		if (attackChance2 >=0 && attackChance2<=100) {
			this.attackChance2 = attackChance2;
		}else {
			System.out.println("attackChance2 can not be negative or over 100");
			throw new IllegalArgumentException("attackChance2 can not be negative or over 100");
		}
	}

	/**
	 * Returns the attackType1 field
	 * @return the attackType1 field
	 */
	public String getAttackType1() {
		return attackType1;
	}

	/**
	 * Changes the attackType1 field with the value passed
	 * will throw IllegalArgumentsException if the parameter is not a String
	 * @param attackType1 name a reference to a String for attackType1 field
	 */
	public void setAttackType1(String attackType1) {
		this.attackType1 = attackType1;
	}

	/**
	 * Returns the attackType2 field
	 * @return the attackType2 field
	 */
	public String getAttackType2() {
		return attackType2;
	}

	/**
	 * Changes the attackType2 field with the value passed
	 * will throw IllegalArgumentsException if the parameter is not a String
	 * @param attackType2 name a reference to a String for attackType2 field
	 */
	public void setAttackType2(String attackType2) {
		this.attackType2 = attackType2;
	}

	/**
	 * Returns the defense field
	 * @return the defense field
	 */
	public String getDefense() {
		return defense;
	}

	/**
	 * Changes the defense field with the value passed
	 * will throw IllegalArgumentsException if the parameter is not a String
	 * @param defense name a reference to a String for defense field
	 */
	public void setDefense(String defense) {
		this.defense = defense;
	}
	
	/**
	 * Provides a comma-separated-value String representation.
	 * There is no formatting of fields, and there is no ending line terminator.
	 * The order of the fields returned is:
	 * name,health,strength,attackDamage,attackChance1,attackChance2,
	 * attackType1,attackType2,defense
	 * return a comma-separated-value String representation.
	 */
	@Override
	public String toString() {
		String format = "%s,%s,%s,%s,%d,%d,%s,%s,%s%n";
		return String.format(format,
				getName(), getHealth(), getStrength(), getAttackDamage(),
				getAttackChance1(), getAttackChance2(), getAttackType1(),
				getAttackType2(), getDefense());
		
	}
}
