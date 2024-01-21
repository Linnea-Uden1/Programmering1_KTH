// LinkedNumberSequence.java

import static java.lang.System.in;

/****************************************************************

LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses linked nodes to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class LinkedNumberSequence implements NumberSequence
{
	private class Node
	{
		public double number;
		public Node next;

		public Node (double number)
		{
			this.number = number;
			next = null;
		}
	}

	// the first node in the node-sequence
    private Node first;

    // create the sequence
    public LinkedNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

        first = new Node(numbers[0]);
        Node n = first;
		for (int i = 1; i < numbers.length; i++)
		{
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		Node n = first;
		while (n.next != null)
		{
		    s = s + n.number + ", ";
		    n = n.next;
		}
		s = s + n.number;

		return s;
	}

    // add code here
	public int length(){
		Node n = first; 
		int count = 0; 
		while (n != null) {
			count++;
			n = n.next;
		}
		return count; 
	}

	public double upperBound(){
		Node upperBound = first; 
		Node n = first; 
		while (n != null) {
			if (upperBound.number < n.number) {
				upperBound.number = n.number;
			}
			n = n.next; 
		}
		return upperBound.number;
	}

	public double lowerBound(){
		Node lowerBound = first;
		Node n = first; 
		
		while (n != null) {
			if (lowerBound.number > n.number) {
				lowerBound.number = n.number;				
			}			
			n = n.next;
		}
		return lowerBound.number; 
	}

	public double numberAt(int position) throws IndexOutOfBoundsException{
		double number = 0; 
		Node n = first;
		int i = 0;
		while (n != null) {
			if (i == position) {
				number = n.number;
				break;
			}
			else{
				n = n.next; 
				i++;
			}
			
		}
		return number; 
	}

	public int positionOf(double number){
		int position = 0; 
		int i = 0;
		Node n = first; 
		while (n != null) {
			if (number == n.number) {
				position = i; 
			}
			else{
				n = n.next; 
				i++;
			}
			
		}
		return position; 
	}

	public boolean isIncreasing(){
		boolean increasing = true; 
		Node n = first; 
		while (n != null && n.next != null) {
			if (n.number >= n.next.number) {
				increasing = false; 
				break;
			}
			n = n.next;
		}
		return increasing;
	}

	public boolean isDecreasing(){
		boolean decreasning = true; 
		Node n = first;

		while (n != null && n.next != null) {
			if (n.number < n.next.number) {
				decreasning = false; 
				break;
			}
		}
		return decreasning; 
	}

	public boolean contains(double number){
		Node n = first;  
		while (n != null) {
			if (n.number == number) {
				return true;
			}
			if (n.next == null) {
				return false; 
			}
			n = n.next;
		}
		return false;
	}

	public void add(double number){
		//Vi skapar noden som ska få värdet number
		Node node = new Node(number);
		Node n = first;
		//Kollar om sequncen är tom och om den är det sätter vi first till nya node
		if (first == null) {
			first = node;
		}
		while (n.next != null)
			n = n.next;

		n.next = node;	
	}

	public void insert(int position, double number) throws IndexOutOfBoundsException{
		Node node = new Node(number);
		//Om vi vill sätta den nya noden till den första, då måste vi flytta den dåvarande firsta noden till andra platsen 
		if (position == 0) {
			node.next = first; 
			first = node; 
		}
		else{
			Node n  = first; 
			for(int i = 0; i < position -1; i++)
				n = n.next; 
			node.next = n.next;
			n.next = node;
		}
	}

	public void removeAt(int position)throws IndexOutOfBoundsException, IllegalStateException{
		Node n = first;
		int i = 0; 
		
		while (n != null) {
			if (i == position - 1) {
				n.next = n.next.next;
			}
			n = n.next; 
			i++;
		}
	}

	public double[] asArray(){
		int l = this.length();
		double[] arr = new double[l];
		int i = 0;
		Node n = first; 
		while (n != null) {
			arr[i] = n.number;
			n = n.next;
			i++;
		}
		return arr; 
	}
}