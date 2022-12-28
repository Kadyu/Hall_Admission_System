package HallAdmissionSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import HallAdmissionSystem.exceptions.InvalidFileException;

public class ComponentsHelper {

	public static int selectExistingHall() throws IOException, InvalidFileException {
		HallAdmissionSystem has = HallAdmissionSystem.getInstance();
		while (true) {
			Integer input = ComponentsHelper.getIntValue("Enter hall:");
			if (has.isHallExists(input)) {
				return input;
			}

			System.out.println("The hall you entered does not exist");
		}
	}

	public static int selectNewHall() throws IOException, InvalidFileException {
		HallAdmissionSystem has = HallAdmissionSystem.getInstance();
		String input;
		Boolean isValidInout;
		Boolean notExistingHall;
		do {
			isValidInout = true;
			notExistingHall = true;
			input = CommandLineInterface.getInp("Enter Hall: ");
			if (!checkInteger(input)) {
				System.out.println("Invalid input!");
				isValidInout = false;
				continue;
			}
			if (has.isHallExists(Integer.parseInt(input))) {
				System.out.println("This Hall already exists!");
				notExistingHall = false;
			}
		} while (!isValidInout || !notExistingHall);
		return Integer.parseInt(input);
	}

	public static String getExamType() {
		return CommandLineInterface.getEnumerateSelection("Enter Exam Type:",
				new ArrayList<>(Arrays.asList("DSE", "IELTS")));
	}

	public static boolean checkInteger(String input) {
		boolean isInteger = false;
		int convertInteger = 0;
		try {
			if (input == null) {
				return false;
			}
			convertInteger = Integer.parseInt(input);
			if (convertInteger >= 0) {
				isInteger = true;
			}
		} catch (NumberFormatException e) {
			isInteger = false;
		}

		return isInteger;
	}

	public static String getLocation() {
		return CommandLineInterface.getEnumerateSelection("Input location:",
				new ArrayList<>(Arrays.asList("Kowloon", "Hong Kong Island", "New Territories", "Overseas")));
	}

	public static int getIntValue(String msg) {
		while (true) {
			String inp = CommandLineInterface.getInp(msg);
			if (checkInteger(inp)) {
				return Integer.parseInt(inp);
			}
			System.out.println("Invalid input, enter a number");
		}
	}

	public static boolean checkDouble(String input) {
		boolean isDouble = false;
		double convertDouble = 0;
		try {
			if (input == null) {
				return false;
			}
			convertDouble = Double.parseDouble(input);
			if (convertDouble >= 0) {
				isDouble = true;
			}
		} catch (NumberFormatException e) {
			isDouble = false;
		}

		return isDouble;
	}

	public static double getDoubleValue(String msg) {
		while (true) {
			String inp = CommandLineInterface.getInp(msg);
			if (checkDouble(inp)) {
				return Double.parseDouble(inp);
			}
			System.out.println("Invalid input, enter a number");
		}
	}

	public static int getCappedIntValue(String msg, int lowerLimit, int upperLimit) {
		while (true) {
			int userInput = getIntValue(msg);
			if (userInput >= lowerLimit && userInput <= upperLimit) {
				return userInput;
			} else {
				System.out.println("The inputted number is out of the acceptable range!");
			}
		}

	}

	public static double getCappedDoubleValue(String msg, double lowerLimit, double upperLimit) {
		while (true) {
			double userInput = getDoubleValue(msg);
			if (userInput >= lowerLimit && userInput <= upperLimit) {
				return userInput;
			} else {
				System.out.println("The inputted number is out of the acceptable range!");
			}
		}

	}
}
