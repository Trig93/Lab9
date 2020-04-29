

import java.util.Scanner;

public class ValidatorMethods {
	
	public static String getString(Scanner userInput, String prompt) {
		System.out.print(prompt);    
		return userInput.nextLine();
	}
	public static int getInt(Scanner userInput, String prompt) {
		System.out.println(prompt);
		boolean isValid = userInput.hasNextInt();
		while(!isValid) {
			userInput.nextLine();
			System.out.println("Sorry, did you mean something else? Please enter a number without decimals.");
			System.out.print(prompt);
			isValid = userInput.hasNextInt();
		}
		int answer = userInput.nextInt();
		userInput.nextLine();
		return answer;
	}
	public static int getIntAtOrAbove(Scanner userInput, String prompt, int minValue) {
		int input = getInt(userInput, prompt);
		if (input < minValue) {
			System.out.println("Sorry, the number must be at least " + minValue);
			return getIntAtOrAbove(userInput, prompt, minValue);
		}else {
			return input;
		}
		
	}
	public static double getDouble(Scanner scnr, String prompt, double min, double max) {
		boolean isValid = false;
		double number;
		do {
			number = getDouble(scnr, prompt);
			
			if (number < min) {
				isValid = false;
				System.out.println("The number must be at least " + min);
			} else if (number > max) {
				isValid = false;
				System.out.println("The number must not be larger than " + max);
			} else {
				isValid = true;
			}
			
		} while (!isValid);
		return number;
	}
	public static String getStringMatchingRegex(Scanner scnr, String prompt, String regex) {
		boolean isValid = false;
		String input;
		do {
			input = getString(scnr, prompt);
			
			if (input.matches(regex)) {
				isValid = true;
			} else {
				System.out.println("Input must match the appropriate format.");
				isValid = false;
			}
			
		} while (!isValid);
		return input;
	}
	public static Date getDate(Scanner scnr, String prompt) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		format.setLenient(false); // <-- date format must match
		boolean isValid = false;
		Date date = null;
		String input;
		do {
			// Step 1: get the raw string
			input = getString(scnr, prompt);
			// Step 2: convert it to a date
			try {
				// format.parse throws a ParseException, which is a checked exception and MUST be caught.
				date = format.parse(input);
				// If exception doesn't occur, it's valid.
				isValid = true;
			} catch (ParseException ex) {
				// If exception occurs, it's invalid.
				isValid = false;
				System.out.println("Enter a valid date in format mm/dd/yyyy.");
			}
			
		} while (!isValid);
		return date;
	}
	public static boolean getYesOrNo(Scanner userInput, String prompt) {
		System.out.println(prompt);
		String input = userInput.nextLine().toLowerCase();
		boolean isValid = input.equals("yes") || input.equals("no");
		while (!isValid) {
			System.out.println("Please enter yes or no.");
			System.out.println(prompt);
			input = userInput.nextLine().toLowerCase();
			isValid = input.equals("yes") || input.equals("no");
		}
		return input.startsWith("y");
	}

}
