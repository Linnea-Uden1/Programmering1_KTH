package A2;
// SynonymHandler

// import static java.lang.System.out;

/****************************************************************

SynonymHandler handles information about synonyms for various
words.

The synonym data can be read from a file and handled in various
ways. These data consists of several lines, where each line begins
with a word, and this word is followed with a number of synonyms.

The synonym line for a given word can be obtained. It is possible
to add a synonym line, and to remove the synonym line for a given
word. Also a synonym for a particular word can be added, or
removed. The synonym data can be sorted. Lastly, the data can be
written to a given file.

Author: Fadil Galjic

****************************************************************/

import java.io.*;    // FileReader, BufferedReader, PrintWriter,
                     // IOException

class SynonymHandler
{
	// readSynonymData reads the synonym data from a given file
	// and returns the data as an array
    public static String[] readSynonymData (String synonymFile) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(synonymFile));
        int numberOfLines = 0;

        String synonymLine = reader.readLine();
        while (synonymLine != null)
        {
			numberOfLines++;
			synonymLine = reader.readLine();
		}
		reader.close();

		String[] synonymData = new String[numberOfLines];
        reader = new BufferedReader(new FileReader(synonymFile));
        
		for (int i = 0; i < numberOfLines; i++)
		    synonymData[i] = reader.readLine();
		reader.close();

		return synonymData;
    }

    // writeSynonymData writes a given synonym data to a given
    // file
    public static void writeSynonymData (String[] synonymData, String synonymFile) throws IOException
    {
        PrintWriter writer = new PrintWriter(synonymFile);
        for (String synonymLine : synonymData)
            writer.println(synonymLine);
        writer.close();

    }

    // synonymLineIndex accepts synonym data, and returns the
    // index of the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
	private static int synonymLineIndex (String[] synonymData,String word) throws IllegalArgumentException
    {
		int delimiterIndex = 0;
		String w = "";
		int i = 0;
		boolean wordFound = false;
		while (!wordFound  &&  i < synonymData.length)
		{
		    delimiterIndex = synonymData[i].indexOf('|');
		    w = synonymData[i].substring(0, delimiterIndex).trim();
		    if (w.equalsIgnoreCase(word))
				wordFound = true;
			else
				i++;
	    }

	    if (!wordFound){
			throw new IllegalArgumentException(word + " not present");
		}

	    return i;
	}

    // getSynonymLine accepts synonym data, and returns
    // the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
    public static String getSynonymLine (String[] synonymData, String word) throws IllegalArgumentException
    {
		int index = synonymLineIndex(synonymData, word);
		
	    return synonymData[index];
	}

    // addSynonymLine accepts synonym data, and adds a given
    // synonym line to the data.
	public static String[] addSynonymLine (String[] synonymData, String synonymLine)
	{
		String[] synData = new String[synonymData.length + 1];
		for (int i = 0; i < synonymData.length; i++)
		    synData[i] = synonymData[i];
		synData[synData.length - 1] = synonymLine;

	    return synData;
	}

//     // removeSynonymLine accepts synonym data, and removes
//     // the synonym line corresponding to a given word.
//     // If the given word is not present, an exception of
//     // the type IllegalArgumentException is thrown.
	public static String[] removeSynonymLine (String[] synonymData,String word) throws IllegalArgumentException
	{
		int index = synonymLineIndex(synonymData, word);
		String[] synData  = new String[synonymData.length-1];
		boolean lineRemoved = false; 
		for(int i = 0; i < synonymData.length; i++){
			if(i == index){
				synData[i] = "";
				lineRemoved = true;
			}
			else{
				if(lineRemoved == true)
					synData[i-1] = synonymData[i];
				else
					synData[i] = synonymData[i];
			}
		}

		return synData; 
	}

//     // getSynonyms returns synonyms in a given synonym line.
	private static String[] getSynonyms (String synonymLine)
	{
		String[] arr = synonymLine.split("\\s*\\|\\s*");
		String synonyms = arr[1];
		String[] synonymsList = synonyms.split("\\s*,\\s*");

		return synonymsList;
	}

//     // addSynonym accepts synonym data, and adds a given
//     // synonym for a given word.
//     // If the given word is not present, an exception of
//     // the type IllegalArgumentException is thrown.
//     //Made the function return a string instead of not returing something
		public static void addSynonym (String[] synonymData, String word, String synonym) throws IllegalArgumentException{

			int index = synonymLineIndex(synonymData, word);
			//Get the line specific line that the synonym should be added to by using getSynonymLine
			String synonymLine; 
			synonymLine = getSynonymLine(synonymData, word);
			synonymLine += ", " + synonym;
			String[] synData = new String[synonymData.length];

			for(int i = 0; i < synonymData.length; i++){
				synData[i] = synonymData[i];
				if(i == index)
					synData[i] = synonymLine;
			}
			for(int i = 0; i < synonymData.length;i++){
				synonymData[i] = synData[i];
			}
	}


//     // removeSynonym accepts synonym data, and removes a given
//     // synonym for a given word.
//     // If the given word or the given synonym is not present, an
//     // exception of the type IllegalArgumentException is thrown.
//     // If there is only one synonym for the given word, an
//     // exception of the type IllegalStateException is thrown.
	public static void removeSynonym (String[] synonymData, String word, String synonym){

		int index = synonymLineIndex(synonymData, word);

		if(index == -1)
			throw new IllegalArgumentException("Word not present in the synonym data");
		// //Get the line specific line that the synonym should be added to by using getSynonymLine
		String synonymLine = getSynonymLine(synonymData, word);
		//Använder synonymLine
		String[] synonyms = getSynonyms(synonymLine);
		String[] synData = new String[synonymData.length];
	
		synonymLine = "";
		boolean synonymRemoved = false; 
		for(int i = 0; i < synonymData.length; i++){
			if(i == index){
				for(String syn: synonyms){
					//== checks to see if they are the same object in memory however .equal will compare the values of String 
					if (syn.equalsIgnoreCase(synonym))
						synonymRemoved = true;
					else
						synonymLine += syn + ", "; 
				}
				if (!synonymRemoved) {
					throw new IllegalArgumentException("Synonym not found for given word");
				}
				synonymLine = word + " | " + synonymLine;
			}
			else{
				synData[i] = synonymData[i];
			}
			synData[index] = synonymLine; 
		}
		for(int i = 0; i < synonymData.length; i++)
			synonymData[i] = synData[i]; 
	}


	
//     // sortIgnoreCase sorts an array of strings, using
//     // the selection sort algorithm
    private static void sortIgnoreCase (String[] strings)
    {
		String temp;
		for(int i = 0; i < strings.length; i++){
			for(int j = i+1; j < strings.length; j++){
				//compareTo compers one string to the others strings 
				if (strings[i].compareTo(strings[j]) > 0) {
					//Swapping posistion of the two strings
					temp = strings[i];
					strings[i] = strings[j];
					strings[j] = temp;
				}
			}
		}
	}

//     // sortSynonymLine accepts a synonym line, and sorts
//     // the synonyms in this line
    private static String sortSynonymLine (String synonymLine)
    {
	    // add code here
		String[] arr = synonymLine.split("\\s*\\|\\s*");
		String synonymWord = arr[0];
		//Get synonyms in the given line 
		String [] synonyms = getSynonyms(synonymLine);
		//Sort the synonyms in the given line 
		sortIgnoreCase(synonyms);
		String str = synonymWord + " | "; 
		for(String word: synonyms){
			str += word + ", "; 
		}

		return str;
	}

//     // sortSynonymData accepts synonym data, and sorts its
//     // synonym lines and the synonyms in these lines
	public static void sortSynonymData (String[] synonymData)
	{
		//Returns a list of only the first word
		// String[] firstWord = new String[synonymData.length];
		// for(int i = 0; i < synonymData.length;i++){
		// 	String[] synonymLine = synonymData[i].split("\\s*\\|\\s*");
		// 	String word = synonymLine[0];
		// 	firstWord[i] = word;
		// }
		// //Sort the first words
		// for(int j = 0; j < firstWord.length; j++){
		// 	sortIgnoreCase(firstWord);
		// }
		// //Create a new String[] to add the sorted lines in 
		// String[] newSynonymData = new String[synonymData.length];

		// for(int i = 0; i < synonymData.length; i++){
		// 	newSynonymData[i] = getSynonymLine(synonymData, firstWord[i]);
		// 	newSynonymData[i] = sortSynonymLine(newSynonymData[i]);
		// 	// System.out.println(newSynonymData[i]);

		// }
		// //Changes the values in synonymData 
		// for(int i = 0; i < synonymData.length; i++){
		// 	synonymData[i] = newSynonymData[i];
		// }
//Mycket lättare lösning
		for(int i = 0; i < synonymData.length; i++){
			synonymData[i] = sortSynonymLine(synonymData[i]);
		}
		sortIgnoreCase(synonymData);
	}
}