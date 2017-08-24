
package exceptions_example;

/* Class: EmptyPriorityQueueException
 * @author - Wade Hedlesky
 * This class extends java.lang.RuntimeException. EmptyPriorityQueueException includes a default constructor
 * that has no parameters and calls this( String ), and another constructor that accepts a String and
 * outputs the String via System.out.println( String )
 */
public class EmptyPriorityQueueException extends java.lang.RuntimeException {
	private static final long serialVersionUID = 4127775508291240313L;

	/* Default constructor calls this(<default exception message>) if no input was given. */
	public EmptyPriorityQueueException()
	{
		this("EXCEPTION: EmptyPriorityQueueException();");
	}
	
	/* Constructor prints the exception message 'err' via System.out.println(String). */
	public EmptyPriorityQueueException(String err)
	{
		System.out.println(err);
	}
}