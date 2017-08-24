
package exceptions_example;

/* Class: InvalidEntryException
 * @author - Wade Hedlesky
 * This class extends java.lang.RuntimeException. InvalidEntryException includes a default constructor
 * that has no parameters and calls this( String ), and another constructor that accepts a String and
 * outputs the String via System.out.println( String )
 */
public class InvalidEntryException extends RuntimeException {
	private static final long serialVersionUID = 3159093314878500773L;
	
	/* Default constructor calls this(<default exception message>) if no input was given. */
	public InvalidEntryException()
	{
		this("EXCEPTION: InvalidEntryException();");
	}
	
	/* Constructor prints the exception message 'err' via System.out.println(String). */
	public InvalidEntryException(String err)
	{
		System.out.println(err);
	}
}
