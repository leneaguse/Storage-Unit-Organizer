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
public class LinkedBoxList {
	private LinkedBoxNode head; // head of this LinkedBoxList (refers to the element
	// stored at index 0 within this list)
	private int size; // number of boxes already stored in this list
	private int capacity; // capacity of this LinkedBoxList
	// maximum number of box elements that this LinkedBoxList
	// can store

	// Creates an empty LinkedBoxList with a given initial capacity
	public LinkedBoxList(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Returns the size of this list
	 * 
	 * @return int
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Returns the capacity of this list
	 * 
	 * @return int
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Expands the capacity size
	 * 
	 * @param int
	 */
	public void expandCapacity(int a) {
		this.capacity += a;

	}

	/**
	 * Checks if the list is empty
	 * 
	 * @return boolean true if it is empty, false if not
	 */
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if the list is at capacity
	 * 
	 * @return true if the list is full false if not
	 */
	public boolean isFull() {
		if (this.size == this.capacity) {
			return true;
		}
		return false;
	}

	/**
	 * A method made to get the head box for testing
	 * 
	 * @return Box
	 */
	public Box getHeadBox() {
		return this.head.getBox();
	}

	/**
	 * Returns the head node for testing
	 * 
	 * @return LinkedBoxNode head
	 */
	public LinkedBoxNode getHead() {
		return this.head;
	}

	/**
	 * Adds a new box to the list throws an Illegal Argument Exception if the box is
	 * null throws an Illegal State Exception if the list is full
	 * 
	 * @param Box box to be added
	 */
	public void add(Box newBox) throws IllegalArgumentException, IllegalStateException {
		LinkedBoxNode currNode = this.head;
		LinkedBoxNode newLink = new LinkedBoxNode(newBox);
		if (newBox == null) {
			throw new IllegalArgumentException("The Box is null");
		} else if (isFull()) {
			throw new IllegalStateException("Cannot add more boxes");
		}
		// if there is no defined head
		else if (this.head == null) {
			this.head = newLink;
			this.size++;
		}
		// if the head is lighter than the new box
		else if (this.head.getBox().compareTo(newBox) < 0) {
			newLink.setNext(currNode);
			this.head = newLink;
			this.size++;
		} else {
			for (int i = 0; i < size; i++) {
				// checks if the box to be added is the lightest
				if (currNode.getNext() == null) {
					currNode.setNext(newLink);
					this.size++;
					break;
				}
				// checks if the curr box is heavier but the next box is lighter
				// than the box to be added
				else if (currNode.getBox().compareTo(newBox) >= 0
						&& currNode.getNext().getBox().compareTo(newBox) < 0) {
					newLink.setNext(currNode.getNext());
					currNode.setNext(newLink);
					this.size++;
					break;
				}
				currNode = currNode.getNext();
			}
		}
	}

	/**
	   * Using the equals() method, checks if two box have the same 
	   * weight and color
	   * 
	   * @return boolean true if the list contains the box,
	   * 		 false if the list does not
	   */
	public boolean contains(Box findBox) {
		LinkedBoxNode currNode = this.head;
		boolean doesContain = false;
		Box compBox;
		//iterates through the list of boxes
		for (int i = 0; i < size; i++) {
			//gets the box at index
			compBox = currNode.getBox();
			//compares the box passed in with the box
			// at the list index
			if (compBox.equals(findBox)) {
				doesContain = true;
			}
			currNode = currNode.getNext();
		}
		return doesContain;
	}

	/**
	   * Gets the box at the specified index
	   * throws an IndexOutOfBoundsException if the index is invalid
	   * 
	   * @return Box at index
	   */
	public Box get(int index) throws IndexOutOfBoundsException {
		LinkedBoxNode currNode = this.head;
		//check if index is valid
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index not reachable");
		}
		//iterate through list
		for (int i = 0; i < size; i++) {
			//check if you're at the index in the list
			if (i == index) {
				return currNode.getBox();
			}
			currNode = currNode.getNext();
		}
		return null;
	}

	/**
	   * Removes a specified box from the list
	   * throws an IndexOutOfBoundsException if the index is invalid
	   * 
	   * @return int
	   */
	public Box remove(int index) throws IndexOutOfBoundsException {
		LinkedBoxNode currNode = this.head;
		// check if index is valid
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index not reachable");
		}
		//iterate through list
		for (int i = 0; i < size; i++) {
			//check if at the index specified
			if (i == index) {
				LinkedBoxNode remNode = currNode.getNext();
				LinkedBoxNode tempNode = currNode.getNext().getNext();
				currNode.setNext(tempNode);
				size--;
				return remNode.getBox();
			}
			currNode = currNode.getNext();
		}
		return null;
	}

	/**
	   * Removes all of the boxes in the list
	   * 
	   */
	public void clear() {
		this.head = null;
		this.size = 0;

	}
	/**
	   * Returns a String representation of the state and content of this
	   * LinkedBoxList
	   * An example of source code for this method is provided you in the next
	   * paragraph
	   * 
	   * @return String
	   */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(); // creates a StringBuilder object
		String newLine = System.getProperty("line.separator");
		result.append("------------------------------------------------" + newLine);
		if (!isEmpty()) {
			LinkedBoxNode runner = head;
			int index = 0;
			// traverse the list and add a String representation for each box
			while (runner != null) {
				result.insert(0, "Box at index " + index + ": " + 
						runner.getBox().getWeight() + " lbs" + newLine);
				runner = runner.getNext();
				index++;
			}
			result.insert(0, "Box List Content:" + newLine);
		}
		result.insert(0, "List size: " + size + " box(es)." + newLine);
		result.insert(0, "Box List is empty: " + isEmpty() + newLine);
		result.insert(0, "------------------------------------------------" + newLine);
		return result.toString();
	}

}

