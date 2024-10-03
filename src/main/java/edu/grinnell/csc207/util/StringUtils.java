package edu.grinnell.csc207.util;

import edu.grinnell.csc207.linear.LinkedStack;
import edu.grinnell.csc207.linear.Stack;

/**
 * Assorted utilities for working with strings.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */ 
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+
    
  /**
   * Determine whether the parens match in string.
   */
  public static boolean checkMatching(String str) throws Exception {
    Stack<Character> parens = new LinkedStack<Character>();
    for(int i = 0; i < str.length(); i++){
      if (str.charAt(i) == '('){
         //didn't complete implementation
      }
    }
    return false;
  } // checkMatching

} // class StringUtils    

