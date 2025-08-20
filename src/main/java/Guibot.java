import java.util.Scanner;

public class Guibot {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String line = "____________________________________________________________";

        System.out.println("\t" + line + "\n\t  Hello! I'm Guibot\n\t  What can I do for you?\n\t" + line + "\n");

	String input = scanner.nextLine();

	while(!input.equals("bye")) {
		System.out.println("\n\t" + line + "\n\t  " + input + "\n\t" + line + "\n");
		input = scanner.nextLine();
	}

	System.out.println("\n\t" + line + "\n\t  Bye. Hope to see you again soon!\n\t" + line + "\n");
    }
}
