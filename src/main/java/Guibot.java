import java.util.Scanner;
import java.util.ArrayList;

public class Guibot {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = "\n\t_________________________________________________________________________________________________";
		System.out.println("\t" + line + "\n\n\t  Hello! I'm Guibot\n\t  What can I do for you?\n" + line + "\n");
		String[] input = scanner.nextLine().split(" ", 2);
		TaskList tasklist = new TaskList();
		while(input.length > 0 && !input[0].equals("bye")) {
			System.out.println(line);
			try {
				switch (input[0]) {
					case "list":
					System.out.println("\n\t  Here are the tasks in your list:" + tasklist.toString());
					break;
				case "mark":
					if (input.length == 2 && input[1].matches("[0-9]*")) {
						System.out.println("\n\t  Nice! I've marked this task as done:\n\t    " + 
								tasklist.mark(Integer.parseInt(input[1]) - 1));
					} else {
						throw new GuibotException("Please type \"mark <index of task>\".");
					}
					break;
				case "unmark":
					if (input.length == 2 && input[1].matches("[0-9]*")) {
						System.out.println("\n\t  OK, I've marked this task as not done yet:\n\t    " + 
								tasklist.unmark(Integer.parseInt(input[1]) - 1));
					} else {
						throw new GuibotException("Please type \"unmark <index of task>\".");
					}
					break;
				case "delete":
					if (input.length == 2 && input[1].matches("[0-9]*")) {
						System.out.println(String.format("\n\t  Noted. I've removed this task:\n\t     %s\n\t  Now you have %d tasks in the list.",
								tasklist.delete(Integer.parseInt(input[1]) - 1), tasklist.size()));
					} else {
						throw new GuibotException("Please type \"delete <index of task>\"");
					}
					break;
				case "todo":
					try {
						Task t = new Todo(getDetails(new String[]{}, input));
						tasklist.add(t);
						System.out.println(String.format("\n\t  Got it, I've added this task:\n\t    %s\n\t  Now you have %d tasks in the list.",
								t.toString(), tasklist.size()));
					} catch (GuibotException e) {
						throw new GuibotException("Please type \"todo <description of task>\".");
					}
					break;
				case "deadline":
					try {
						Task t = new Deadline(getDetails(new String[]{" /by "}, input));
						tasklist.add(t);
						System.out.println(String.format("\n\t  Got it, I've added this task:\n\t    %s\n\t  Now you have %d tasks in the list.",
								t.toString(), tasklist.size()));
					} catch (GuibotException e) {
						throw new GuibotException("Please type \"deadline <description of task> /by <deadline of task>\".");
					}
					break;
				case "event":
					try {
						Task t = new Event(getDetails(new String[]{" /from ", " /to "}, input));
						tasklist.add(t);
						System.out.println(String.format("\n\t  Got it, I've added this task:\n\t    %s\n\t  Now you have %d tasks in the list.",
								t.toString(), tasklist.size()));
					} catch (GuibotException e) {
						throw new GuibotException("Please type \"event <description of event> /from <start of event> /to <end of event>\".");
					}
					break;
				default:
					throw new UnknownRequestException();
				}
			} catch (GuibotException e) {
				System.out.println("\n\t  " + e.toString());
			}
			System.out.println("\t" + line + "\n");
			input = scanner.nextLine().split(" ", 2);
		}
		System.out.println(line + "\n\n\t  Bye. Hope to see you again soon!\n\t" + line + "\n");
	}

	public static String[] getDetails(String[] splitters, String[] input) throws GuibotException {
		if (input.length != 2) {
			throw new GuibotException("no information");
		}
		String toSplit = input[1];
		String[] details = new String[splitters.length + 1];
		for (int i = 0; i < splitters.length; i++) {
			String[] temp = toSplit.split(splitters[i], 2);
			if (temp.length < 2) {
				throw new GuibotException(splitters[i]);
			}
			details[i] = temp[0];
			toSplit = temp[1];
		}
		details[splitters.length] = toSplit;
		return details;
	}
}
