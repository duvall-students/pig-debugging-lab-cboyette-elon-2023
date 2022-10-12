import java.util.Random;

public class Spinner {
	private String[] sections = {"Oink", "Squeal", "Snort", "GRUNT"};
	// This means that "oink" should happen 20% of the time, "Squeal" 50%, etc...
	// I am assuming the probabilities add to 1.
	private double[] probabilities = {.2, .5, .27, .03};
	private Random spinRandom;
	
	public Spinner(){
		spinRandom = new Random();
	}
	
	public String spin(){
		double spinNumber = spinRandom.nextDouble();
		return numToWord(spinNumber);
	}			
	
	/*
	 * Turn the random number into one of the spinner words 
	 * based on the given probabilities.
	 */
	public String numToWord(double spinNumber){	
//		int index = 1;
// 		The above code doesn't work because arrays start at index 0
// 		By starting index at 1, it will never equal Oink and will try to access an element at index 4
//		While the array only goes up to index 3
		int index = 0;
		double low = 0;
		boolean done = false;
		String result = "";
		while(!done){
			System.out.println("spin number: " + spinNumber);
			System.out.println("low: " + low);
			System.out.println("probaility: " + probabilities[index]);
			System.out.println("index: " + index);
			double high = probabilities[index] + low;
			System.out.println("high: " + high);
			if(spinNumber>= low && spinNumber< high){
				result = sections[index];
				done = true;
			}
			else{
				low = high;
				index++;
			}
		}
		return result;
	}

}
