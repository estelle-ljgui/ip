import java.util.Scanner;

class Ui {
	private Scanner scanner;
	
	public Ui() {
		this.scanner = new Scanner(System.in);
	}

	public void showLine() {
		System.out.println("\n\t_________________________________________________________________________________________________\n");
	}

	public void showWelcome() {
		showLine();
		System.out.println("\t  Hello! I'm Guibot\n\t  What can I do for you?");
		showLine();
	}

	public void showString(String string) {
		System.out.println("\t  " + string);
	}

	public void showError(GuibotException e) {
		System.out.println("\t  " + e.getMessage());
	}

	public String readInput() {
		return scanner.nextLine();
	}
}
