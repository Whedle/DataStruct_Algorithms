
package exceptions_example;

/* Class: EmptyStackException
 * @author - Wade Hedlesky
 * This class extends java.lang.RuntimeException. EmptyStackException includes a default constructor
 * that has no parameters and calls this( String ), and another constructor that accepts a String and
 * outputs the String via System.out.println( String )
 */
public class EmptyStackException extends java.lang.RuntimeException {
	private static final long serialVersionUID = -8557233992026344135L;

	/* Default constructor calls this(<default exception message>) if no input was given. */
	public EmptyStackException()
	{
		this("EXCEPTION: EmptyStackException();");
	}
	
	/* Constructor prints the exception message 'err' via System.out.println(String). */
	public EmptyStackException(String err)
	{
		System.out.println(err);
	}
}
