
package exceptions_example;

/* Class: FullStackException
 * @author - Wade Hedlesky
 * This class extends java.lang.RuntimeException. FullStackException includes a default constructor
 * that has no parameters and calls this( String ), and another constructor that accepts a String and
 * outputs the String via System.out.println( String )
 */
public class FullStackException extends java.lang.RuntimeException {
	private static final long serialVersionUID = -7380614160753060639L;
	
	/* Default constructor calls this(<default exception message>) if no input was given. */
	public FullStackException()
	{
		this("EXCEPTION: FullStackException();");
	}
	
	/* Constructor prints the exception message 'err' via System.out.println(String). */
	public FullStackException(String err)
	{
		System.out.println(err);
	}
}
