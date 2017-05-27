package edu.gatech.oad.antlab.person;

/**
 *  A simple class for person 2
 *  returns their name and a
 *  modified string
 *
 * @author Simola Nayak
 * @version 1.1
 */
public class Person2 {
    /** Holds the persons real name */
    private String name;
	 	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
	 public Person2(String pname) {
	   name = pname;
	 }
	/**
	 * This method should take the string
	 * input and return its characters in
	 * random order.
	 * given "gtg123b" it should return
	 * something like "g3tb1g2".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
      //declare new string to build
      String scrambled = "";
      //loop that runs as long as input has at least one character
      while(input.length() > 0) {
          //random number, to be locked in for the rest of the loop turn
          int deadSpot = (int) Math.random() * input.length();
          //the character to be deleted
          String deadLet = input.substring(deadSpot, deadSpot + 1);
          //adding the character
          scrambled += deadLet;
          //the character will be gone by replacing it with nothing
          input = input.replaceFirst(deadLet, "");
      }
      return scrambled;
	}
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}
}
