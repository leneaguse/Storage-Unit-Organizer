//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           (descriptive title of the program making use of this file)
// Files:           (a list of all source files used by that program)
// Course:          (course number, term, and year)
//
// Author:          Lenea Guse
// Email:           laguse@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         N/A
// Online Sources:  N/A
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
public class StorageUnitTests {
	public static void main(String[] args) {
		System.out.println(testBoxEquals());
		System.out.println(testBoxCompareTo());
		System.out.println(testAddMethod());
		System.out.println(testLinkedBoxListRemove());
		System.out.println(testContains());
		System.out.println(testGet());
	}
	/**
	 * Checks if the box equals() method is implemented correctly
	 * 
	 * @return boolean
	 */
	public static boolean testBoxEquals() {
		// set up parameters
		boolean testOne = false;
		Box box1 = new Box(12, 15);
		Box box2 = box1;
		Box box3 = new Box(12, 15);
		Object box4 = new Object();
		// call the equals method
		boolean test1 = box1.equals(box2);
		boolean test2 = box1.equals(box3);
		boolean test3 = box1.equals(box4);
		// test if the returns are correct
		if (test1 && test2 && !test3) {
			testOne = true;
		}
		return testOne;
	}
	/**
	 * Checks if the implementation of compareTo() is correct
	 * 
	 * @return boolean
	 */
	public static boolean testBoxCompareTo() {
		// set up parameters
		boolean testTwo = false;
		Box box1 = new Box(12, 15);
		Box box2 = new Box(12, 17);
		Box box3 = new Box(12, 15);
		Box box4 = new Box(12, 2);
		// call compareTo
		int test1 = box1.compareTo(box2);
		int test2 = box1.compareTo(box3);
		int test3 = box1.compareTo(box4);
		// test if the returns are as expected
		if (test1 == 1 && test2 == 0 && test3 == -1) {
			testTwo = true;
		}
		return testTwo;
	}
	/**
	 * Checks if the implementation of remove() is correct
	 * 
	 * @return boolean
	 */
	public static boolean testLinkedBoxListRemove() {
		// set up parameters
		boolean test3 = false;
		Box box1 = new Box(12, 14);
		LinkedBoxNode link1 = new LinkedBoxNode(box1);
		Box box2 = new Box(12, 17);
		LinkedBoxNode link2 = new LinkedBoxNode(box2);
		Box box3 = new Box(12, 5);
		LinkedBoxNode link3 = new LinkedBoxNode(box3);
		LinkedBoxList theList = new LinkedBoxList(12);
		// add boxes to the list
		theList.add(box1);
		theList.add(box2);
		theList.add(box3);
		// remove the box at index 1
		theList.remove(1);
		// checks if the box was removed
		if (theList.size() == 2) {
			test3 = true;
		}
		return test3;
	}
	/**
	 * Checks if the add method was correctly implemented
	 * 
	 * @return boolean
	 */
	public static boolean testAddMethod() {
		// set up parameters
		boolean test4 = false;
		Box box1 = new Box(12, 14);
		Box box2 = new Box(12, 17);
		Box box3 = new Box(12, 5);
		LinkedBoxList theList = new LinkedBoxList(12);
		// add the boxes to the list
		theList.add(box1);
		theList.add(box2);
		theList.add(box3);
		// receive the weights of all of the boxes in the list
		int link1Weight = theList.getHeadBox().getWeight();
		int link2Weight = theList.getHead().getNext().getBox().getWeight();
		int link3Weight = theList.getHead().getNext().getNext().getBox().getWeight();
		// check if the order of the list is correct and the size is correct
		if (link1Weight == 17 && link2Weight == 14 && link3Weight == 5 && theList.size() == 3) {
			test4 = true;
		}
		return test4;
	}
	/**
	 * Checks if the contains method was correctly implemented
	 * 
	 * @return boolean
	 */
	public static boolean testContains() {
		// set up parameters
		boolean test5 = false;
		Box box1 = new Box(12, 14);
		Box box2 = new Box(12, 17);
		Box box3 = new Box(12, 5);
		Box box4 = new Box(13, 2);
		LinkedBoxList theList = new LinkedBoxList(12);
		// add the boxes to the list
		theList.add(box1);
		theList.add(box2);
		theList.add(box3);

		if (theList.contains(box1) && !theList.contains(box4)) {
			test5 = true;
		}
		return test5;
	}
	/**
	 * Checks if the get method was correctly implemented
	 * 
	 * @return boolean
	 */
	public static boolean testGet() {
		// set up parameters
		boolean test6 = false;

		Box box1 = new Box(12, 14);
		Box box2 = new Box(12, 17);
		Box box3 = new Box(12, 5);

		LinkedBoxList theList = new LinkedBoxList(12);
		// add the boxes to the list
		theList.add(box1);
		theList.add(box2);
		theList.add(box3);
		// get boxes from the list
		Box box5 = theList.get(0);
		Box box4 = theList.get(1);
		Box box6 = theList.get(2);
		// check that the boxes are the correct ones to be retrieved

		if (box4.equals(box1) && box5.equals(box2) && box6.equals(box3)) {
			test6 = true;
		}

		return test6;
	}
}
