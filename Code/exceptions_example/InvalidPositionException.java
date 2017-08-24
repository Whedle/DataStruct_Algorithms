
package exceptions_example;

/* Class: InvalidPositionException
 * @author - Wade Hedlesky
 * This class extends java.lang.RuntimeException. InvalidPositionException includes a default constructor
 * that has no parameters and calls this( String ), and another constructor that accepts a String and
 * outputs the String via System.out.println( String )
 */
public class InvalidPositionException extends java.lang.RuntimeException{
	private static final long serialVersionUID = 6754409343724509811L;

	/* Default constructor calls this(<default exception message>) if no input was given. */
	public InvalidPositionException()
	{
		this("EXCEPTION: InvalidPositionException();");
	}
	
	/* Constructor prints the exception message 'err' via System.out.println(String). */
	public InvalidPositionException(String err)
	{
		System.out.println(err);
	}
}
