package calculatorLevels;

import java.util.Scanner;
import java.util.ArrayList;

public class Jedi {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numOfIngredients = scan.nextInt(); //read in number of ingredients
		
		// Create arrays for info needed later
		String [] nameOfIngredient = new String [numOfIngredients];
		
		
		// for each ingredient: read in name, price/oz, vegetarian or not, cal/oz
		for ( int i = 0 ; i < numOfIngredients ; i++ ) {
			nameOfIngredient[i] = scan.next();
			double pricePerOz = scan.nextDouble();
			boolean isVeg = scan.nextBoolean();
			double calPerOz = scan.nextDouble();
		}
		

		/** Begin block of code to get info about each menu item **/
		
		int numMenuItems = scan.nextInt();
		
		String [] nameOfMenu = new String [numMenuItems];
		int [] numIngMenu = new int [numOfIngredients];
		String [] menuIngred = new String[numOfIngredients];
		double [] ouncesReq = new double[numOfIngredients];
		
		double [][] ingredQty = new double [numMenuItems][] ;
		String [][] ingredientNames = new String [numMenuItems][];
		
		// for each menu item, read in the number of ingredients
		for(int i = 0 ; i < numMenuItems ; i++) { //begin for loop
			
			nameOfMenu [i]=scan.next(); 
			int menuIngredredients = scan.nextInt();
			ingredientNames[i] = new String[menuIngredredients];
			ingredQty[i] = new double[menuIngredredients];
			
			// for each ingredient, read in name and amount of ounces
			
			for (int j = 0 ; j < menuIngredredients ; j++ ) { //begin nested for loop
				ingredientNames[i][j] = scan.next();
				ingredQty[i][j] = scan.nextDouble();

			} // end nested for loop
		}// end original for loop
		
		/** End block of code to get info about each menu item **/
		

		ArrayList<String> orders = new ArrayList<String>();
			
		while(scan.hasNext() ) {
			String currentItem = scan.next();
			if(currentItem.equals("EndOrder")) {
				break;
			}
			orders.add(currentItem);
			
		} //end while loop
		
		double [] totalOunces = new double [nameOfIngredient.length];
		
		for(int i = 0 ; i < orders.size(); i++) {
			String currentItem = orders.get(i);
			int indx = findIndex (nameOfMenu, currentItem);
			
			for( int j = 0 ; j < ingredientNames[indx].length; j++) {
				
				String currentIngred = ingredientNames[indx][j];
				int ingredIndex = findIndex(nameOfIngredient, currentIngred);
				totalOunces[ingredIndex] += ingredQty[indx][j];
			}
		}
		
		System.out.println("The order will require:");
		for(int l = 0 ; l < nameOfIngredient.length; l++) {
			System.out.println( String.format("%.2f", totalOunces[l]) + " ounces of " + nameOfIngredient[l] );
		}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} //end main, helper class methods are below 
	
	public static int findIndex (String[]itemNames, String nameItem) {
		int indx=0;
		for(int i = 0; i<itemNames.length; i++) {
			if(itemNames[i].equals(nameItem)) {
				indx = i;
			}
		}
		return indx;
	}
	
	public static int roundInt (double x) {
		return ((int)(x+0.5));
	}
	
} //end A2iedi Class
