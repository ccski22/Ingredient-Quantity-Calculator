package calculatorLevels;

import java.util.Scanner;

public class Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		/**Read in a list of ingredients **/
		
		int numMenuItems = scan.nextInt();
		String [] namesIngred = new String  [numMenuItems];
		double [] pricesArray = new double [numMenuItems];
		boolean [] vegArray = new boolean [numMenuItems];
		double [] calsArray = new double [numMenuItems];
		
		
		
		for (int i = 0; i < numMenuItems ; i++) {
			
		namesIngred[i] = scan.next();
		pricesArray[i] = scan.nextDouble();
		vegArray[i] = scan.nextBoolean();
		calsArray[i] = scan.nextDouble();
		
		}// end for loop
	
		/**Read in a list of menu items**/
		
		
		int menuRecipes = scan.nextInt();

		
		// For each menu item recipe, find name and number of ounces
		
			for (int j = 0; j < menuRecipes ; j++) { //begin for loop #1
				
				String nameItem = scan.next();
				int numIngredItem = scan.nextInt();
				boolean [] recipeVegArray = new boolean [numIngredItem];
				boolean isRecipeVeg = false;
				double costPerItem = 0;
				double calorieCountperItem = 0;
				
			
					for (int k = 0 ; k < numIngredItem ; k++) { // begin for loop #2
						
	
						String ingredName = scan.next(); 
						double ouncesReq = scan.nextDouble();
						
						// First find the index
						int indexOfItem = findIndex(namesIngred, ingredName);
						
						recipeVegArray[k] = vegArray[indexOfItem];
						
						
						calorieCountperItem += calsArray[indexOfItem] * ouncesReq;
						costPerItem += pricesArray[indexOfItem] * ouncesReq;
						

					}// end for loop #2
					isRecipeVeg = isItemVegetarian (recipeVegArray);
			// Calculate calorie count, total cost, whether item is vegetarian		
			
			
			System.out.println(nameItem + ":");
			System.out.println("   "+ roundInt(calorieCountperItem) + " calories");
			System.out.println("   $" + String.format("%.2f",costPerItem));
			if(isRecipeVeg == true) {
				System.out.println("   Vegetarian");
			}
			if(isRecipeVeg == false) {
				System.out.println("   Non-Vegetarian");
			}
			} // end for loop #1
				
		
		/**Print out information about menu items**/
			
			
	} //end main method
	 
	public static int findIndex (String[]itemNames, String nameItem) {
		int indx=0;
		for(int i = 0; i<itemNames.length; i++) {
			if(itemNames[i].equals(nameItem)) {
				indx = i;
			}
		}
		return indx;
	}
	
	public static boolean isItemVegetarian (boolean[]isVegetarianArray) {
		
		boolean veg = true;
		
		for(int i = 0; i < isVegetarianArray.length ; i++) {
			
			if( isVegetarianArray[i] == false) {
				veg = false; 
			}
		}
			
		return veg;
	}
	
	public static int roundInt (double x) {
		return ((int)(x+0.5));
	}
	
} //end class
