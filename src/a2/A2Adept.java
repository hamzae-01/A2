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

		//below for loop is going through first list of ingred.
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


/*input
6
Rice 0.12 true 37
Seaweed 2.95 true 113
Avocado 0.22 true 45
Salmon 1.77 false 48
Yellowtail 0.53 false 41
Eel 2.18 false 84

4

Avocado_Roll
3
Rice 0.5
Avocado 0.5
Seaweed 0.1

Unagi_Nigiri
2
Rice 0.75
Eel 0.75

KMP_Roll
4
Eel 0.6
Rice 0.4
Seaweed 0.2
Avocado 0.3

Salmon_Sashimi
1
Salmon 0.8*/