import java.util.Scanner;
import java.util.ArrayList;

public class Guibot {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String line = "_________________________________________________________________________________________________";

        System.out.println("\t" + line + "\n\n\t  Hello! I'm Guibot\n\t  What can I do for you?\n\n\t" + line + "\n");

	String input = scanner.nextLine();
	TaskList tasklist = new TaskList();

	while(!input.equals("bye")) {

		System.out.println("\n\t" + line);

		try {

			if (input.equals("list")) {

				System.out.println("\n\t  Here are the tasks in your list:" + tasklist.toString());

			} else if (input.matches("mark [0-9]*")) {

				int taskNumber = Integer.parseInt(input.substring(5));
				System.out.println("\n\t  Nice! I've marked this task as done:\n\t  " + tasklist.mark(taskNumber - 1));

			} else if (input.matches("unmark [0-9]*")) {

				int taskNumber = Integer.parseInt(input.substring(7));
				System.out.println("\n\t  OK, I've marked this task as not done yet:\n\t  " + tasklist.unmark(taskNumber - 1));

			} else if (input.matches("delete [0-9]*")) {

				int taskNumber = Integer.parseInt(input.substring(7));
				System.out.println(String.format("\n\t  Noted. I've removed this task:\n\t    %s\n\t  Now you have %d tasks in the list.",
							tasklist.delete(taskNumber - 1), tasklist.size()));

				
			} else if (input.matches("todo.*")) {

				if (!input.matches("todo .*")) {
					throw new ImproperFormatException(0);
				}

				Task t = new Todo(input.substring(5));
				tasklist.add(t);
				System.out.println(String.format("\n\t  Got it, I've added this task:\n\t    %s\n\t  Now you have %d tasks in the list.",
							t.toString(), tasklist.size()));

			} else if (input.matches("deadline.*")) {

				if (!input.matches("deadline .* /by .*")) {
					throw new ImproperFormatException(1);
				} 

				String[] split = input.split(" /by ");
				Task t = new Deadline(split[0].substring(9), split[1]);
				tasklist.add(t);
				System.out.println(String.format("\n\t  Got it, I've added this task:\n\t    %s\n\t  Now you have %d tasks in the list.",
							t.toString(), tasklist.size()));

			} else if (input.matches("event.*")) {

				if (!input.matches("event .* /from .* /to .*")) {
					throw new ImproperFormatException(2);
				}

				String[] split = input.split(" /");
				Task t = new Event(split[0].substring(6), split[1].substring(5), split[2].substring(3));
				tasklist.add(t);
				System.out.println(String.format("\n\t  Got it, I've added this task:\n\t    %s\n\t  Now you have %d tasks in the list.",
							t.toString(), tasklist.size()));

			} else {

				throw new UnknownRequestException();

			}

		} catch (GuibotException e) {

			System.out.println("\n\t  " + e.toString());

		}

		System.out.println("\n\t" + line + "\n");
		input = scanner.nextLine();
	}

	System.out.println("\n\t" + line + "\n\n\t  Bye. Hope to see you again soon!\n\n\t" + line + "\n");
    }
}
