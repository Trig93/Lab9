import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Lab9 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		boolean orderAgain;
		HashMap<String, Double> menuItems = new HashMap<>();
		ArrayList<String> orderedItems = new ArrayList<>();
		ArrayList<Double> orderedCost = new ArrayList<>();
		menuItems.put("bread", 1.99);
		menuItems.put("eggs", 1.59);
		menuItems.put("milk", 3.59);
		menuItems.put("cheese", 2.99);
		menuItems.put("ham", 3.99);
		menuItems.put("chicken", 4.99);
		menuItems.put("soda", 1.99);
		menuItems.put("beer", 5.99);
		System.out.println("Welcome to Trig's Tiny Market!");
		System.out.println("");
		while(orderAgain = true) {
		System.out.println("Item"+ "\t" +"Price");
		System.out.println("-------------");
		for(Map.Entry<String, Double> entry : menuItems.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		System.out.println("");
		System.out.println("What would you like to order?");
		String menuItem = scnr.nextLine().toLowerCase();
		System.out.println("How much was that?");
		Double itemCost = scnr.nextDouble();
		Double validItem = menuItems.put(menuItem, itemCost);
		if (validItem != null) {
			System.out.println("Adding " + menuItem + " to your cart for " + itemCost + "." + "\n");
			orderedItems.add(menuItem);
			orderedCost.add(itemCost);
			System.out.print("Would you like to order anything else?");
			orderAgain = ValidatorMethods.getYesOrNo(scnr, "" + "\n");
			if(orderAgain != true) {
				break;
			}
		}else {
			System.out.println("I'm sorry, we don't carry that item. Would you like to order anything else?");
			orderAgain = ValidatorMethods.getYesOrNo(scnr, "" + "\n");
			if(orderAgain != true) {
				break;
			}
		}
}
		System.out.println("Thanks for shopping at Trig's Tiny Market!");
		System.out.println("Here's what you ordered: ");
		for (int i = 0; i < orderedItems.size(); i++) {
			String items = orderedItems.get(i);
			Double costs = orderedCost.get(i);
			HashMap<String, Double> total = new HashMap<>();
			total.put(items, costs);
			System.out.println(items + "\t" + costs);
		}
		double averageCost = averageThis(orderedCost);
		System.out.printf("The average cost of your items bought is: " + "%.2f", averageCost);
		System.out.println("");
		scnr.close();
		System.out.println("Goodbye!");
}
	private static double averageThis (ArrayList<Double> i) {
		double a = 0;
		for(int j = 0; j < i.size();j++) {
			if(i.get(j)>a) {
				a += i.get(j)/3;
			}
		}
		return a;
	}
}































