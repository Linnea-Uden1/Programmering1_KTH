package A3;
// ArrayNumberSequence.java

/****************************************************************

ArrayNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses an array to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class ArrayNumberSequence implements NumberSequence
{
	// numbers in the sequence
    private double[] numbers;

    // create the sequence
    public ArrayNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

		this.numbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
		    this.numbers[i] = numbers[i];
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		for (int i = 0; i < numbers.length - 1; i++)
		    s = s + numbers[i] + ", ";
		s = s + numbers[numbers.length - 1];

		return s;
	}
    // add code here

	// length returns the number of numbers in this sequence.
	public int length () {
		return numbers.length;
		
	}
    // upperBound returns an upper bound for this sequence.
    public double upperBound () {
		double upperBound = 0; 
		for(int i = 0; i < this.numbers.length; i++){
			if(numbers[i] > upperBound){
				upperBound = numbers[i];
			}
		}
		return upperBound;

	}

    // lowerBound returns a lower bound for this sequence.
    public double lowerBound () {

		//lowerBound = 0 gick inte eftersom att det då blir det "minsta" talet   
		double lowerBound = this.numbers[0];

		for(int i = 0; i < this.numbers.length; i++){
			if (this.numbers[i] < lowerBound) {
				lowerBound = this.numbers[i];
			}
		}
		return lowerBound;

	}

    // numberAt returns the number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    public double numberAt (int position) throws IndexOutOfBoundsException {
		for(int i = 0; i < this.numbers.length; i++){
			
		}
		double number = 1.5;
		return number;
		}

    // positionOf returns the position of the first occurance of
    // the specified number in this sequence.
    // If the number is not present in the sequence, -1 is returned.
	public int positionOf (double number) {
		return 0;
	}


    // isIncreasing returns true if this sequence is increasing,
    // else false is returned.
    public boolean isIncreasing () {
		return true;
	}

    // isDecreasing returns true if this sequence is decreasing,
    // else false is returned.
    public boolean isDecreasing () {
		return true;
	}

	// contains returns true if this sequence contains the
    // specified number, else false is returned.
	public boolean contains (double number) {
		return false;
	}

	// add adds the specified number to the end of this sequence.
	public void add (double number) {
	}

	// removeAt removes the number at the specified position
	// in this sequence.
	// The method throws IndexOutOfBoundsException if the
	// position is wrong.
	// The method throws IllegalStateException if there are
	// just two numbers in the sequence.
	public void removeAt(int position) { // throws IndexOutOfBoundsException, IllegalStateException;

	}	

	// insert inserts the given number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    public void insert (int position, double number) { // throws IndexOutOfBoundsException;

	}


	public double[] asArray () {
		// Incomplete
		double[] array = {1, 2, 3};
		return array;
	}




















}
