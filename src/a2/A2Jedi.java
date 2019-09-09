package a2;

import java.util.ArrayList;
import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Your code here.
		int ingredient = scan.nextInt();
		// number of ingredients (6)
		String[] ingredientName = new String[ingredient];
		// names of sushi ingredients
		double[] cost = new double[ingredient];
		// price per ounce
		boolean[] vegetarian = new boolean[ingredient];
		// true or false for vegetarian food or not
		int[] cal = new int[ingredient];
		// number of calories per ounce

		for (int i = 0; i < ingredient; i++) {
			ingredientName[i] = scan.next();
			cost[i] = scan.nextDouble();
			vegetarian[i] = scan.nextBoolean();
			cal[i] = scan.nextInt();
		}
		
		int orders = scan.nextInt();
		// number of orders (4)
		String[] ordername = new String[orders];
		// name of orders
		double [][] ingOunce = new double[orders][ingredient];
		// 2d array creates ounces of ingredient for each order
		
		
		for (int h = 0; h < orders; h++) {
			ordername[h] = scan.next();
			int numbingred = scan.nextInt();

			for (int j = 0; j < numbingred; j++) {
				String ingname = scan.next();

				int index = 0;

				for (int l = 0; l < ingredient; l++) {
					if (ingname.equals(ingredientName[l])) {
						index = l;
					}
				}

				
				ingOunce[h][index] = scan.nextDouble();
			}
		}

		String listorder = scan.next();
		ArrayList<String> ingitems = new ArrayList<String>();
		// ing items is rice etc. in output
		double[] outounces = new double[ingredient];
		int index2 = 0;
		while (!listorder.equals("EndOrder")) {
			int index3 = 0;
			for (int g = 0; g < orders; g++) {
				if (listorder.equals(ordername[g])) {
					index3 = g;
				}

			}

			double[] orderOunce = ingOunce[index3];
			
			for (int z = 0; z<orderOunce.length; z++ ) {
				outounces[z] = outounces[z] + orderOunce[z];
			}
			
			listorder = scan.next();
			index2 += 1;
		}
		System.out.println("The order will require:");
		for (int e = 0; e < outounces.length; e++) {
			System.out.println(String.format("%.2f", outounces[e]) + " ounces of " + ingredientName[e]);
		}

	}

	// You can define helper methods here if needed.

}
