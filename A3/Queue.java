// Queue.java
package A3;

public interface Queue
{
	boolean isEmpty ();
	int size ();
	void put (char element);
	char take () throws IllegalStateException;
}
