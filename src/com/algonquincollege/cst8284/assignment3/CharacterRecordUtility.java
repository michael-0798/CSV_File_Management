/*
 * Assessment: CST8284 Assignment 03 (21W)
 * Modified by Student: Michael Wang
 * Lab Section: 314
 * Lab Professor: Leanne Seaward
 */
package com.algonquincollege.cst8284.assignment3;

import java.io.*;
import java.util.*;

/**
 * the class is the main function of the program. The functions include:
 * 1, read contents from a CSV file;
 * 2, save the contents into a new CSV file;
 * 3, sort the contents which read from the CSV file; 
 * @author mikew
 *
 */
public class CharacterRecordUtility {
	
	private String columnNames = null; // used for storing the column names.
	
	// create an arrayList to take the records from CSV files
	List <CharacterRecord> records = new ArrayList();
	
	/**
	 * 1st, the method will call the loadFile() to read the original CSV file and convert
	 * contents to the objects of CharacterRecords, then add the objects into the 
	 * arrayList records;
	 * 2nd, it will call sortName() to sort the records' elements by name, and 
	 * call saveFile() to save the new elements into the new CSV file;
	 * 3rd, it will call sortAttackChance1() to sort the records elements by AttackChance1,
	 * and then call saveFile() to save the new results into the new CSC file;
	 * exceptions will be caught in the process;
	 */
	public void processFile()  {
		try {
			System.out.println(
					"Attempting to open CharacterRecordsUnsorted.csv ...");
			loadFile();
			
			System.out.println("Sorting by name ...");
			sortName();
			
			System.out.println("Saving to SortedByName.csv ...");
			System.out.println("(Will overwrite any file with same name)");
			saveFile("SortedByName.csv");
			
			System.out.println("Sorting by attackChance1 ...");
			sortAttackChance1();
			
			System.out.println("Saving to SortedByAttackChance1.csv ...");
			System.out.println("(Will overwrite any file with same name)");
			saveFile("SortedByAttackChance1.csv");
			
			System.out.println("Character Data Sorted and Saved.");
			System.out.println("Program by Michael Wang");

		}
		catch(IllegalArgumentException e) {
			// catch and re-throw the IllegalArgumentException from the chained methods
			throw e;
		}catch (FileNotFoundException e) {
			// note:  will only print the name and message of the exception!
//			System.out.println(e);
			
			// note: will print the name, message, and 'get' all trace of the exception
			e.getStackTrace();
			
			/*
			 *  note: will not only 'get' the all the traces, but also 'print' them,
			 *  could be used with sysout.err 
			 */
//			e.printStackTrace();
		}
		catch (Exception e) {
			// catch any other exception
			e.getStackTrace();
		}
	}
	
	
	/**
	 * At first, The loadFile() will clear the arrayList records. 
	 * Then, the method will open and read the values from the target CSV file. 
	 * It will identify each single line as a seperate object of CharacterRecord class, 
	 * and take each cell of the line and set it as the value of the fields of that object.
	 * All CharacterRecord object will be added to the arrayList records.  
	 * @throws java.io.IOException   the exceptions will be catched in the method, but will 
	 * still declare in the method signature for the remind purpose 
	 */
	private void loadFile() throws IOException{
		
		// clear the arrayList, in case it has been called and altered
		records.clear();
		
		// create the file to be loaded
		File f1 = new File("CharacterRecordsUnsorted.csv");

		// declare and initialize the BufferedReader
		BufferedReader br = null;
		
		try {
			// read the csv file
			br = new BufferedReader(new FileReader(f1));
		} catch (FileNotFoundException e) {
			// catch the exception if the file is not found
			System.out.println("file as "+ f1.getName()+" is not found");
			e.printStackTrace();
		}
		
		// create a String to receive the value of "next line" of the file
		String str = null;
		
		// creat a counter
		int counter = 0;
		
		// read and get the value from the file, until the end of the file
		try {
			while((str = br.readLine())!= null) {
				
				if(counter == 0) {
					// the first line of the CSV file is the header of the new file
					columnNames = str;
					
					/*
					 *  note: must, must, must append \n to the columnNames, otherwise, when 
					 *  writing the streams into the csv, 
					 *  all the first element in the list will be concated right after the heard!!
					 */
					columnNames += "\n";
				}
				
				// skip the first line of the file, which is the header
				if (counter >=1) {
					/*
					 *  split the str by seperate sign ",", and form them into an array,
					 the new array contains all the fields to be set into the CharacterRecord
					 */
					String[] split = str.split(",");
					
					/* 
					 * check if there's extra commas in the fields, if yes, then the
					 *  specific array's length will larger than the standard size,
					 *  additionally, we should use the first line of the table(header of the table)
					 *  to determine the "standard size" of each line (array)  
					*/ 
					if (split.length>columnNames.split(",").length) {
						System.out.println("no comma should be added into the fields");
						throw new IllegalArgumentException("no comma should be added into the fields");
					}
					
					// create the object of CharacterRecord
					CharacterRecord chr = new CharacterRecord();
					
					// set the values into the instance chr, in order
					chr.setName(split[0]);
					chr.setHealth(split[1]);
					chr.setStrength(split[2]);
					chr.setAttackDamage(split[3]);
					chr.setAttackChance1(Integer.parseInt(split[4]));
					chr.setAttackChance2(Integer.parseInt(split[5]));
					chr.setAttackType1(split[6]);
					chr.setAttackType2(split[7]);
					chr.setDefense(split[8]);
					
					// add the chr into the list
					records.add(chr);
					
				}
				// every time br finishes reading a line, counter ++
				counter++;
			}
		}
		catch (NumberFormatException e) {	
			/* 
			 * to catch the exception if the value to be set as setAttackChance1
			 *  and setAttackChance2 in not valid
			 */
			System.out.println("the number in the field is invalid");
			throw new NumberFormatException();
//			e.printStackTrace();
		} 
		catch (IOException e) {
			// to catch other IO exceptions
			throw new IOException();
		}finally {
			try {
				// close the stream of br
				// note: put it in the finally block, to ensure the file closed
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		

	/**
	 * sortName() is override the NameComparator's abstract method, will compare
	 * 2 objects' name, and then sort the objects in the Collections.sort();
	 */
	private void sortName() {
		Collections.sort(records, new NameComparator() {
			@Override
			public int compare(CharacterRecord o1, CharacterRecord o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		// lambda
		//	Collections.sort(records,(o1,o2)-> o1.getName().compareTo(o2.getName()));
	}
	
	
	/**
	 * sortName() is override the NameComparator's abstract method, will compare
	 * 2 objects' AttackChance1(), and then sort the objects in the Collections.sort();
	 */
	private void sortAttackChance1() {
		
		Collections.sort(records, new AttackChance1Comparator() {
			@Override
			public int compare(CharacterRecord o1, CharacterRecord o2) {
				return o1.getAttackChance1()-o2.getAttackChance1();
			}
		});
		// lambda
//		Collections.sort(records,(o1,o2)-> o1.getAttackChance1()-o2.getAttackChance1());
	}
	

	/**
	 * saveFile() method will convert the CharacterRecord objects in the arrayList
	 * records to the contents which will be written into the target CSV file.
	 * Each object in the arrayList will form a new line in the new CSV file.
	 * @param fileName		the target CSV file which will be written in;
	 * @throws IOException   exceptions will be catched in the method, but will 
	 * still declare in the method signature for the remind purpose 
	 */
	private void saveFile(String fileName) throws IOException{
		
		// create the file to be written in, passed the fileName to identify the file path
		File f1 = new File(fileName);
		
		BufferedWriter bw = null;
		
		try {// create the BufferedWriter stream
			 bw = new BufferedWriter(new FileWriter(f1));
			 
			// write the header first
			bw.write(columnNames);
			
			// go through the arrayList records via iterator, and write in each record(line)
			Iterator<CharacterRecord> it = records.iterator();
			while(it.hasNext()) {
				
			// assign each CharacterRecord instance's String value to a variable 
			String content = it.next().toString();
				
			// write the content into the file
			bw.write(content);
			}
			
		} catch (FileNotFoundException e) {
			// if the file is opened, display the reminder and catch the exception
			System.out.println(f1.getName()+": The process cannot access the file because it is being used by another process");
			e.printStackTrace();
			throw new FileNotFoundException("The process cannot access the file because it is being used by another process");
		} catch (IOException e) {
			// catch any other IOException
			e.printStackTrace();
		}finally {
			// close bw
			try{bw.close();
			}catch(IOException e){
				e.getStackTrace();
			}
		}
	}
}
