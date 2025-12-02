package org.generations.exceptions;

public class StudentNotFoundException extends Exception {

	  public StudentNotFoundException(String msg )
	    {
	        super(msg);
	        System.out.println(msg);
	    }
}
