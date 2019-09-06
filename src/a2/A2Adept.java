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
		String[] ordername = new String [orders];
		int[] finalcals = new int[orders];
		double[] rollcost = new double[orders];
		boolean[] nonveg = new boolean [orders];
		for (int h=0; h<orders; h++) {
			ordername [h] = scan.next();
			int numbingred = scan.nextInt();
			
			for (int j=0; j<numbingred; j++) {
				String ingname= scan.next();
				
				int index=0;
				
				for(int l=0; l<ingredient; l++) {
					if(ingname.equals(ingredientName[l])) {
						index = l;
					}
				}
					double numberofounces = scan.nextDouble();
					finalcals[h] += ((int) ((numberofounces * cal[index])+.5));
			rollcost[h] += numberofounces * cost[index];
			if(vegetarian[index] == false) {
				nonveg[h] = true;
			}
			
		}
			System.out.println(ordername[h] + ":");	
			System.out.println("  " + finalcals[h]);
			System.out.println("  " + String.format("%.2f",rollcost[h]));
			if(nonveg[h] == true) {
				System.out.println("  Non-Vegetarian");	
			} else {
				System.out.println("  Vegetarian");
			}
		
	}
	
	
}
}
