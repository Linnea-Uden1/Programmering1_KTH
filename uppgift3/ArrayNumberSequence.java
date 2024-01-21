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
	public int length(){
		return this.numbers.length; 
	}

	public double upperBound(){
		double upperBound = 0;
		for(int i = 0; i < this.numbers.length; i++){
			if(this.numbers[i] > upperBound)
				upperBound = this.numbers[i];
		}
		return upperBound;
	}

	public double lowerBound(){
		double lowerBound = this.numbers[1];
		for(int i = 0; i < this.numbers.length; i++)
			lowerBound = this.numbers[i];
		return lowerBound;
	}

	public double numberAt(int position) throws IndexOutOfBoundsException{
		double number = this.numbers[position]; 
		return number; 
	}

	public int positionOf(double number){
		int position = -1;
		for(int i = 0; i < this.numbers.length; i++){
			if(number == this.numbers[i]){
				position = i; 
			}
		}
		return position;
	}

	public boolean isIncreasing(){
		boolean isIncreasing = true; 
		double currentNumber = this.numbers[0];
		int i = 0; 
		while (isIncreasing && i < numbers.length) {
			if (currentNumber > this.numbers[i]) {
				isIncreasing = false;
				break;
			}
			currentNumber = this.numbers[i];
			i++;
		} 

		return isIncreasing;
	}

	public boolean isDecreasing(){
		boolean isDecreasing = true; 
		int i = 0;
		while (isDecreasing && i+1 < this.numbers.length ) {
			if (this.numbers[i] < this.numbers[i+1]) {
				isDecreasing = false; 
				break;
			}
			i++;

		}
		return isDecreasing; 
	}

	public boolean contains(double number){
		boolean contains = false; 
		for(int i = 0; i < this.numbers.length; i++){
			if (this.numbers[i] == number)
				contains = true;
		}
		return contains;
	}

	public void add(double number){
		int lenght = this.numbers.length + 1;
		
		double[] newNumbers = new double[lenght];
		for(int i = 0; i < this.numbers.length; i++){
			newNumbers[i] = this.numbers[i]; 
			newNumbers[lenght-1] = number;
		}

		this.numbers = newNumbers;

	}

	public void insert(int position, double number) throws IndexOutOfBoundsException{
		int lenghtOfArr = this.numbers.length +1; 
		double[] newNumbers = new double[lenghtOfArr];
		for(int i = 0; i < this.numbers.length; i++){
			if (i < position) {
				newNumbers[i] = this.numbers[i];
			}
			else{
				newNumbers[i+1] = this.numbers[i];
			}			
		}
		newNumbers[position] = number; 


		this.numbers = newNumbers;

	}

	public void removeAt(int position) throws IndexOutOfBoundsException, IllegalStateException{
		double[] newNumbers = new double[this.numbers.length - 1];
		//Anlednigen till att jag har ett k värde är för att i värdet kommer hoppa över positions 7 och bli 8 vilket är utanför intervallet 
		for(int i = 0,k = 0; i < this.numbers.length; i++){
			if (i != position) {
				newNumbers[k] = this.numbers[i];
				k++;
			}
		}
		this.numbers = new double[this.numbers.length-1];
		this.numbers = newNumbers;

	}

	public double[] asArray(){
		return this.numbers; 
	}
}