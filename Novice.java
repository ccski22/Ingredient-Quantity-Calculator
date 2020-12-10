package calculatorLevels;

import java.util.Scanner;

public class Novice { //begin class

	public static void main(String[] args) { // begin main
		
		Scanner scan = new Scanner(System.in);
		
		int numIngredients = scan.nextInt();
		int countVeg = 0;
		double [] CPDarray = new double[numIngredients];
		String [] ingredNames = new String[numIngredients];
		
			for (int i = 0 ; i<numIngredients ; i++) {
				
			ingredNames[i] = scan.next();
			double pricePerOz = scan.nextDouble();
			boolean isVeg = scan.nextBoolean();
			double calsPerOz = scan.nextDouble();
			
			CPDarray[i] = calsPerOz/pricePerOz;
			
				if(isVeg==true) {
					countVeg ++;
				}
			}// end for loop
		
		
		System.out.println("Number of vegetarian ingredients: "+countVeg);
		System.out.println("Highest cals/$: "+ findMax(CPDarray, ingredNames));
		System.out.println("Lowest cals/$: "+ findMin(CPDarray, ingredNames));
	scan.close();
	}// end main
	
	
	public static String findMax(double[]CPDarray, String[]ingredNames) {
	
	double maxCPO = CPDarray[0];
	String maxName = ingredNames[0];
	
	for(int j = 1; j < CPDarray.length; j++) {
	
	if(CPDarray[j] > maxCPO) {
		maxCPO = CPDarray[j];
		maxName = ingredNames[j];
	}

	} //end for loop
	return maxName;
	}// end helper method
	
	
	public static String findMin(double[]CPDarray, String[]ingredNames) {
		
		double minCPO = CPDarray[0];
		String minName = ingredNames[0];
		
		for(int k = 1; k < CPDarray.length; k++) {		
		if(CPDarray[k] < minCPO) {
			minCPO = CPDarray[k];
			minName = ingredNames[k];
		}
		
		} //end for loop
		return minName;
		}// end helper method
	
	
}// end class
