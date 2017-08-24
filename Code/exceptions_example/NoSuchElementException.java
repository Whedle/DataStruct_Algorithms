
package exceptions_example;

/* Class: NoSuchElementException
 * @author - Wade Hedlesky
 * This class extends java.lang.RuntimeException. NoSuchElementException includes a default constructor
 * that has no parameters and calls this( String ), and another constructor that accepts a String and
 * outputs the String via System.out.println( String )
 */
public class NoSuchElementException extends RuntimeException{
	private static final long serialVersionUID = 7906870591890716667L;

	/* Default constructor calls this(<default exception message>) if no input was given. */
	public NoSuchElementException()
	{
		this("EXCEPTION: NoSuchElementException():");
	}
	
	/* Constructor prints the exception message 'err' via System.out.println(String). */
	public NoSuchElementException(String err)
	{
		System.out.println(err);
	}
}
