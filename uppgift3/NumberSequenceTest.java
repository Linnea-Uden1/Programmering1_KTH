// NumberSequenceTest.java

/****************************************************************

NumberSequenceTest is a test program for the classes
ArrayNumberSequence and LinkedNumberSequence.

Author
Fadil Galjic

****************************************************************/

import static java.lang.System.out;

import java.util.Arrays;

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

        out.println("Lenght: " + sequence.length());
        out.println("Upperbound: " + sequence.upperBound());
        out.println("Lowerbound: " + sequence.lowerBound());
        out.println("");

        int posistion = 3; 
        double number = 8.0;
        out.println("Nummer at posistion " + posistion + ": " + sequence.numberAt(posistion) );
        out.println("Position of " + number + ": " + sequence.positionOf(number));
        out.println("");

        double contains = 16; 
        double add = 32;
        out.println("Increasing: " + sequence.isIncreasing());
        out.println("Decreasning: " + sequence.isDecreasing());
        out.println("Contains " + contains + ": " + sequence.contains(contains));
        out.println("");

        int insertPos = 7; 
        double insertNum = 0.0;
        int removePos = 7; 

        sequence.add(add);
        out.println("Add " + add + ": ");
        out.println(sequence);
        sequence.insert(insertPos, insertNum);
        out.println("Insert " + insertNum + " at posistion " + insertPos);
        out.println(sequence);
        sequence.removeAt(removePos);
        out.println("Remove at posistion: " + removePos);
        out.println(sequence.toString());

        out.println("");
        out.println("Corresponding array: ");
        out.println(Arrays.toString(sequence.asArray()));
        out.println("");





        // add code here
    }
}