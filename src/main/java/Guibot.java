import java.util.Scanner;
import java.util.ArrayList;

public class Guibot {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String line = "_________________________________________________________________________________________________";

        System.out.println("\t" + line + "\n\t  Hello! I'm Guibot\n\t  What can I do for you?\n\t" + line + "\n");

	String input = scanner.nextLine();
	TaskList tasklist = new TaskList();

	while(!input.equals("bye")) {

		System.out.println("\n\t" + line);

		try {

			if (input.equals("list")) {

				System.out.println("\n\t  Here are the tasks in your list:" + tasklist.toString());

			} else if (input.matches("mark [1-9][0-9]*")) {

				int taskNumber = Integer.parseInt(input.replaceAll("[^0-9]", ""));
			
				System.out.println("\n\t  Nice! I've marked this task as done:\n\t  " + tasklist.mark(taskNumber - 1));

			} else if (input.matches("unmark [1-9][0-9]*")) {

				int taskNumber = Integer.parseInt(input.replaceAll("[^0-9]", ""));
			
				System.out.println("\n\t  OK, I've marked this task as not done yet:\n\t  " + tasklist.unmark(taskNumber - 1));

			} else {

				System.out.println("\n\t  Ok, I've added: \n\t  " + tasklist.add(input));

			}

		} catch (TaskNotFoundException e) {

			System.out.println("\n\t  The index specified does not correspond to a task in the list. Please try again");

		}

		System.out.println("\n\t" + line + "\n");
		input = scanner.nextLine();
	}

	System.out.println("\n\t" + line + "\n\t  Bye. Hope to see you again soon!\n\t" + line + "\n");
    }
}
