/** Tests the construction of a list of CharData objects. */
public class Test2Backup {
	
	public static void main(String args[]) {
	    testBuildList();
		testBuildListWithProbabilities();
	}

	public static void testBuildList() {
		System.out.println("Testing the construction of a list of CharData objects " + 
			               "from a given string input.");
		System.out.println("The probability fields of the CharData objects will be initialized to 0.");
		String input = "committee ";
		System.out.println("Input = \"" + input + "\"");
		List q = buildList(input);
		System.out.println("List = " + q);	
		System.out.println();		
	}

	public static void testBuildListWithProbabilities() {
		System.out.println("Testing the construction of a list of CharData objects " + 
			               "from a given string input.");
		System.out.println("This time, the probability fields will be computed and set correctly.");
		String input = "committee ";
		System.out.println("Input = \"" + input + "\"");
		List q = buildList(input);
		// Calcualates the probalities
		calculateProbabilities(q);
		// Prints the list with the calculates probabilities
		System.out.println("List =  " + q);	
		System.out.println();	
	}
	
	// Builds a list of CharData objects from a given string.
	private static List buildList(String input) {
		List chr = new List();
		for(int i=0; i< input.length(); i++){
			chr.update(input.charAt(i));
		}
		return chr;
	}

	// Computes and sets the probabilities (p and pp fields) in all the
	// CharData objects in the given list.
	public static void calculateProbabilities(List list) {
		int counter = 0;
		for(int i=0 ; i< list.getSize(); i++){
			counter += list.get(i).count;
		}
		for(int j=0; j< list.getSize(); j++){
			list.get(j).p = (double) list.get(j).count / counter;
		}
		double totalPP = 0;
		for (int k=0; k< list.getSize(); k++){
			list.get(k).pp = list.get(k).p + totalPP;
			totalPP += list.get(k).p;
		}
	}
}
