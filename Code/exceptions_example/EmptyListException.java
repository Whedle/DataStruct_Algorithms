
package exceptions_example;

/* Class: EmptyListException
 * @author - Wade Hedlesky
 * This class extends java.lang.RuntimeException. EmptyListException includes a default constructor
 * that has no parameters and calls this( String ), and another constructor that accepts a String and
 * outputs the String via System.out.println( String )
 */
public class EmptyListException extends java.lang.RuntimeException {
	private static final long serialVersionUID = 1911238228560430873L;

	/* Default constructor calls this(<default exception message>) if no input was given. */
	public EmptyListException()
	{
		this("EXCEPTION: EmptyListException();");
	}
	
	/* Constructor prints the exception message 'err' via System.out.println(String). */
	public EmptyListException(String err)
	{
		System.out.println(err);
	}
}