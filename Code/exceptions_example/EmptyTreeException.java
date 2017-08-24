
package exceptions_example;

/* Class: EmptyTreeException
 * @author - Wade Hedlesky
 * This class extends java.lang.RuntimeException. EmptyTreeException includes a default constructor
 * that has no parameters and calls this( String ), and another constructor that accepts a String and
 * outputs the String via System.out.println( String )
 */
public class EmptyTreeException extends java.lang.RuntimeException {
	private static final long serialVersionUID = 2029207097789229340L;
	
	/* Default constructor calls this(<default exception message>) if no input was given. */
	public EmptyTreeException()
	{
		this("EXCEPTION: EmptyTreeException();");
	}
	
	/* Constructor prints the exception message 'err' via System.out.println(String). */
	public EmptyTreeException(String err)
	{
		System.out.println(err);
	}
}
