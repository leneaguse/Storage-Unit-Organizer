
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
import java.util.Random;

public class Box implements Comparable<Box> {
	private static Random randGen = new Random(); // generator of random numbers
	private int color; // color of this box
	private int weight; // weight of this box in lbs between 1 inclusive and 31 exclusive

	// Creates a new Box and initializes its instance fields color and weight to
	// random values
	public Box() {
		this.weight = randGen.nextInt(30) + 1;
		this.color = randGen.nextInt();
	}

	// Creates a new Box and initializes its instance fields color and weight to the
	// specified values
	// Throws IllegalArgumentException if the provided weight value is out of the
	// range of [1..30]
	public Box(int color, int weight) {
		this.color = color;
		if (weight < 1 || weight > 30) {
			throw new IllegalArgumentException("Error: weight out of bounds");
		} else {
			this.weight = weight;
		}

	}

	/**
	 * Compares the object passed in with the instance box checks if they have the
	 * same color and weight
	 * 
	 * @param Object other
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof Box) {
			Box box2 = (Box) other;
			if (box2.weight == this.weight && box2.color == this.color) {
				return true;
			}
		}
		return false;
	} // equals method defined in Object class

	/**
	 * Compares two boxes weights
	 * 
	 * @param Box otherBox
	 * @return 1 if otherBox is lighter 0 if otherBox is the same weight -1 if
	 *         otherBox is heavier
	 */
	@Override
	public int compareTo(Box otherBox) {
		if (this.weight > otherBox.weight) {
			return 1;
		}
		if (this.weight == otherBox.weight) {
			return 0;
		} else {
			return -1;
		}
	} // compareTo method defined in Comparable<Box>
		// interface

	/**
	 * Gets this instance of color
	 * 
	 * @param color number
	 */
	public int getColor() {
		return this.color;
	} // Getter for the instance field color of this box

	/**
	 * Gets this instance of weight
	 * 
	 * @param int weight
	 */
	public int getWeight() {
		return this.weight;
	} // Getter for the instance field weight of this box

}
