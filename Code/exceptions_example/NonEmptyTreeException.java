
package exceptions_example;

/* Class: NonEmptyTreeException
 * @author - Wade Hedlesky
 * This class extends java.lang.RuntimeException. NonEmptyTreeException includes a default constructor
 * that has no parameters and calls this( String ), and another constructor that accepts a String and
 * outputs the String via System.out.println( String )
 */
public class NonEmptyTreeException extends RuntimeException{
	private static final long serialVersionUID = -542910403056751775L;

	/* Default constructor calls this(<default exception message>) if no input was given. */
	public NonEmptyTreeException()
	{
		this("EXCEPTION: NonEmptyStringException();");
	}
	
	/* Constructor prints the exception message 'err' via System.out.println(String). */
	public NonEmptyTreeException(String err)
	{
		System.out.println(err);
	}
}
