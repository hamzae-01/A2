package a2;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Your code here.
		int ingredient = scan.nextInt(); 
		// number of ingredients (6)
		String[] ingredientName = new String [ingredient];
		// names of sushi ingredients
		double[] cost = new double [ingredient];
		//price per ounce
		boolean[] vegetarian = new boolean [ingredient];
		// true or false for vegetarian food or not
		int[] cal = new int[ingredient];
		// number of calories per ounce
		double[] calsperD = new double [ingredient];
		//used to find highest and lowest calories

		for(int i =0; i < ingredient; i++) {
			ingredientName[i]= scan.next();
			cost[i] = scan.nextDouble();
			vegetarian[i] = scan.nextBoolean();
			cal[i] = scan.nextInt();
			calsperD[i] += cal[i]/cost[i];
			//equation to calculate cals/$
		}
		int orders = scan.nextInt();
		// number of orders (4)
		String[] ordername = new String [orders];
		// name of orders
		int[] finalcals = new int[orders];
		// creates calories in output
		double[] rollcost = new double[orders];
		// adds all the costs to get price of menu item
		boolean[] nonveg = new boolean [orders];
		//tells whether menu item is non vegetarian
		for (int h=0; h<orders; h++) {
			ordername [h] = scan.next();
			int numbingred = scan.nextInt();
			double temp = 0;
			
			for (int j=0; j<numbingred; j++) {
				String ingname= scan.next();

				int index=0;

				for(int l=0; l<ingredient; l++) {
					if(ingname.equals(ingredientName[l])) {
						index = l;
					}
				}
				double numberofounces = scan.nextDouble();
				temp += numberofounces * cal[index];
				rollcost[h] += numberofounces * cost[index];
				if(vegetarian[index] == false) {
					nonveg[h] = true;
				}

			}

			finalcals[h] += ((int) ((temp+.5))); //has to be outside for loop in order to avoid premature rounding
			System.out.println(ordername[h] + ":");	
			System.out.println("  " + finalcals[h] + " calories");
			System.out.println("  $" + String.format("%.2f",rollcost[h]));
			if(nonveg[h] == true) {
				System.out.println("  Non-Vegetarian");	
			} else {
				System.out.println("  Vegetarian");
			}

		}


	}
}
