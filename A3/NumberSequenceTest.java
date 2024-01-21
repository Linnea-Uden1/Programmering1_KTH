// NumberSequenceTest.java
package A3;

/****************************************************************

NumberSequenceTest is a test program for the classes
ArrayNumberSequence and LinkedNumberSequence.

Author
Fadil Galjic

****************************************************************/

import static java.lang.System.out;

class NumberSequenceTest
{
    public static void main (String[] args)
    {
		double[] realNumbers = {8.0, 2.0, 16.0, 5.0, 1.0, 12.0, 4.0};
        NumberSequence sequence = null;
        sequence = new ArrayNumberSequence(realNumbers);
        //sequence = new LinkedNumberSequence(realNumbers);
        out.println("the sequence:");
        out.println(sequence);
        out.println();
        // out.println("lenght: " + sequence.length());
        // out.println(sequence.upperBound());
        // out.println(sequence.lowerBound());
        // sequence.insert(2, 1);
        out.println(sequence);
        // add code here
    }
}