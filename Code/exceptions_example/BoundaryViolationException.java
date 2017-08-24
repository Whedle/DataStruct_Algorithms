
package exceptions_example;

/* Class: BoundaryViolationException
 * @author - Wade Hedlesky
 * This class extends java.lang.RuntimeException. BoundaryViolationException includes a default constructor
 * that has no parameters and calls this( String ), and another constructor that accepts a String and
 * outputs the String via System.out.println( String )
 */
public class BoundaryViolationException extends java.lang.RuntimeException{
	private static final long serialVersionUID = -8194334197151937568L;

	/* Default constructor calls this(<default exception message>) if no input was given. */
	public BoundaryViolationException()
	{
		this("EXCEPTION: BoundaryViolationException");
	}

	/* Constructor prints the exception message 'err' via System.out.println(String). */
	public BoundaryViolationException(String err)
	{
		System.out.println(err);
	}
}
