// LinkedNumberSequence.java
package A3;

import static java.lang.System.console;

/****************************************************************

LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses linked nodes to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class LinkedNumberSequence implements NumberSequence
{
	//En klass som skapar cellen Node 
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
		//This connects the boxes(nods) togheter 
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
		//Om det inte finns någon box(node) efter så blir värdet n.next = null 
		while (n.next != null)
		{
		    s = s + n.number + ", ";
		    n = n.next;
		}
		s = s + n.number;

		return s;
	}

    // add code here

	//Returns how many nnumbers are in the sequence 
	public int lenght(){
		// return numbers.length; 

		Node temp = first;
		int count = 0; 

		while (temp != null) {
			count++;
			temp = temp.next; 
		}
		return count;
	}

	//Returns the highest number of the sequnce 
	public double upperBound(){
		Node temp = first; 
		Node max = first; 
		while(temp != null){
			if (max.number <  temp.number) {
				max.number = temp.number; 
			}
			temp = temp.next;
		}
		return max.number; 
	}

	//Returns the lowest number of the sequenc
	public double lowerBound(){
		Node temp = first; 
		Node min = first; 

		while (temp != null) {
			if (min.number > temp.number) {
				min.number = temp.number; 
			}
			temp = temp.next; 

		}
		return min.number;
	}
	//Returns a number of a specific posistion 
	public double numberAt(int position){
		double number = 1.5;
		return number;
	}

	public int positionOf(double number){
		int posistion = 0; 
		int i = 0; 
		Node n = first; 
		while (n != null) 
		{
			if (number == n.number) 
			{
				posistion = i; 
			}	
			else{
				n = n.next;
				i++;
			}
		}
		return posistion; 
	}

	public boolean isIncreasing(){
		return true;
	}

	public boolean isDecreasing(){
		return true;
	}

	public boolean contains(double number){
		return false;
	}
	public void add(double number){
		//Vi skapar noden vi vill lägga till med värdet double number 
		Node node = new Node(number);
		Node n = first; 
		//Kolla om lista är tom och om den är det sätter vi first till nya node
		if(first == null)
			first = node; 
		
		while (n.next != null)
			n = n.next;

		n.next = node; 

	}

	public void insert(int posistion, double number){
		Node node = new Node(number);
		//Om vi vill sätta den nya noden till den första, då måste vi flytta den dåvarande firsta noden till andra platsen 
		if (posistion == 0) {
			node.next = first; 
			first = node;
		}
		else{
			Node n = first; 
			for(int i = 0; i < posistion - 1; i++)
				n = n.next; 
			node.next = n.next; 
			n.next = node; 
		}
	}

	public void removeAt(int posistion){

	}

	public double[] asArray(){
		double[] arrray = {1,2,3};
		return arrray;
	}

	@Override
	public int length() {


		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'length'");
	}




}