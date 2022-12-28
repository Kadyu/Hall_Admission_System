package HallAdmissionSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandLineInterface {
	
	
	private static Scanner sc;
	
	public static void start() {
		sc = new Scanner(System.in);
	}
	
	private static void printBars(int width) {
		for (int i = 0; i < width; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}

	public static String getInp(String msg) {
		System.out.println(msg);
		System.out.print(">> ");
		String inp = sc.nextLine();
		return inp;
	}

	public static void printHeading(String heading) {
		printBars(heading.length());
		System.out.println(heading);
		printBars(heading.length());
	}

	public static void printHC(String heading, String content) {
		printHeading(heading);
		System.out.println(content);
		System.out.println("");
	}

	public static Integer getMenuSelection(String heading, ArrayList<String> options) {
		printHeading(heading);
		for (int i = 0; i < options.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + options.get(i));
		}
		while (true) {
			Integer userInput = ComponentsHelper
					.getIntValue("Please enter the number corresponding to the desired option.");
			if (userInput >= 1 && userInput <= options.size()) {
				return userInput;
			}
			System.out.println("Selected option is not in the menu. Please input again!");
		}
	}

	public static String getEnumerateSelection(String message, ArrayList<String> options) {
		String output = message + " [";
		for (int i = 0; i < options.size(); i++) {
			if (i > 0) {
				output += "/";
			}
			output += options.get(i);
		}
		output += "]";
		while (true) {
			String userInput = CommandLineInterface.getInp(output);
			for (String option : options) {
				if (userInput.equals(option)) {
					return userInput;
				}
			}
			System.out.println("Selected option does not exist. Please input again!");
		}
	}
	
	public static void close() {
		sc.close();
	}
}