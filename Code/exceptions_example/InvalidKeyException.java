
package exceptions_example;

/* Class: InvalidKeyException
 * @author - Wade Hedlesky
 * This class extends java.lang.RuntimeException. InvalidKeyException includes a default constructor
 * that has no parameters and calls this( String ), and another constructor that accepts a String and
 * outputs the String via System.out.println( String )
 */
public class InvalidKeyException extends java.lang.RuntimeException {
	private static final long serialVersionUID = 3634594958255223031L;
	
	/* Default constructor calls this(<default exception message>) if no input was given. */
	public InvalidKeyException()
	{
		this("EXCEPTION: InvalidKeyException();");
	}
	
	/* Constructor prints the exception message 'err' via System.out.println(String). */
	public InvalidKeyException(String err)
	{
		System.out.println(err);
	}
}
