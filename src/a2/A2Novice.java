package a2;

import java.util.Scanner;

public class A2Novice {

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
		int totalcount = 0;
		//count of vegetarien items
		int index=0;
		double[] calsperD = new double [ingredient];
		//used to find highest and lowest calories
		for(int na = 0; na < ingredient; na++) {
			calsperD[na] = 0.0;
		}
		for(int i =0; i < ingredient; i++) {
			ingredientName[i]= scan.next();
			cost[i] = scan.nextDouble();
			vegetarian[i] = scan.nextBoolean();
			cal[i] = scan.nextInt();
			if(vegetarian[i] == true) {
				totalcount += 1;
			}
			calsperD[i] += cal[i]/cost[i];
			//equation to calculate cals/$
		}
		int big=0;
		int small=0;
		for(int x=0; x<ingredient; x++) {
			if(calsperD[x] > calsperD[big]) {
				big = x;
				//ingredientName[big];
			}
			if(calsperD[x] < calsperD[small]) {
				small = x;
			}
			
		}
		System.out.println("Number of vegetarian ingredients: " + totalcount);
		System.out.println("Highest cals/$: " + ingredientName[big]);
		System.out.println("Lowest cals/$: " + ingredientName[small]);
		
	}
	
	// You can define helper methods here if needed.
	

}
