/*
 * Assessment: CST8284 Assignment 03 (21W)
 * Modified by Student: Michael Wang
 * Lab Section: 314
 * Lab Professor: Leanne Seaward
 */
package com.algonquincollege.cst8284.assignment3;

import java.util.Comparator;

/**
 * the abstract class is used to sort the objects of the class CharacterRecord
 * by name. t implements Comparator, overrided the compare method, 
 * and the compare() will be implemented in the implementing class.
 * the advantage to use abstract class here is: the compare() method could be more
 * flexible when being called and implemented in the class
 * 
 * the class is declared as abstract because it will be more flexible when being
 * called and implemented, especially when the rule of comparing is changed
 * @author mikew
 *
 */
public abstract class NameComparator implements Comparator<CharacterRecord>{
	/**
	 * the compare() method is overrided. It added the generic of CharacterRecord,
	 * to make sure the types of both parameters must be entered as the instance 
	 * of CharacterRecord.
	 * it is declared as abstract because it's more flexible, the implemented classes
	 * could have different rules to compare the values via overriding in their
	 * own class, without chaning the source code here everytime.
	 * @param o1 the instance of CharacterRecord, means that only the instances 
	 * of CharacterRecord class can be operated in this class's method
	 * @param o2 the instance of CharacterRecord
	 */
	@Override
	public abstract int compare(CharacterRecord o1, CharacterRecord o2) ;

	/* 
	 * concrete body, if declaring the non-abstract class
	 * the dis-advantage of using a non-abstract class and concrete method() is:
	 * if we want to change the rule of comparing, we have to make changes in the 
	 * source code here or even creating new class every time
	 */
//	public int compare(CharacterRecord o1, CharacterRecord o2) {
//		return o1.getName().compareTo(o2.getName());
//	}

}
