package guibot;

import guibot.exception.GuibotException;
import java.util.Scanner;

/**
 * Handles user interactions
 */
public class Ui {
	private Scanner scanner;

	/**
	 * Initialises a Ui object
	 */
	public Ui() {
		this.scanner = new Scanner(System.in);
	}

	/**
	 * Prints out a line
	 */
	public void showLine() {
		System.out.println("\n\t_________________________________________________________________________________________________\n");
	}

	/**
	 * Prints out a welcome message
	 */
	public void showWelcome() {
		showLine();
		System.out.println("\t  Hello! I'm Guibot\n\t  What can I do for you?");
		showLine();
	}

	/**
	 * Prints out a string
	 *
	 * @param string String to be printed
	 */
	public void showString(String string) {
		System.out.println("\t  " + string);
	}

	/**
	 * Prints out an error message
	 *
	 * @param e Error to be shown
	 */
	public void showError(GuibotException e) {
		System.out.println("\t  " + e.getMessage());
	}

	/**
	 * Returns input string from the user
	 */
	public String readInput() {
		return scanner.nextLine();
	}
}
