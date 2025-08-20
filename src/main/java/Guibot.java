import java.util.Scanner;
import java.util.ArrayList;

public class Guibot {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String line = "____________________________________________________________";

        System.out.println("\t" + line + "\n\t  Hello! I'm Guibot\n\t  What can I do for you?\n\t" + line + "\n");

	String input = scanner.nextLine();
	ArrayList<String> list = new ArrayList<>();

	while(!input.equals("bye")) {
		System.out.println("\n\t" + line);

		if (input.equals("list")) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(String.format("\n\t  %d. %s", i + 1, list.get(i)));
			}
		} else {
			list.add(input);
			System.out.println("\n\t  added: " + input);
		}

		System.out.println("\n\t" + line + "\n");
		input = scanner.nextLine();
	}

	System.out.println("\n\t" + line + "\n\t  Bye. Hope to see you again soon!\n\t" + line + "\n");
    }
}
