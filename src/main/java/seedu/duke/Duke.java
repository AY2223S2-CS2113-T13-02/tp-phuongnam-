package seedu.duke;

import MajorClasses.ExpenseList;
import parser.Parser;

import java.util.Scanner;

public class Duke {

    public static Parser parser = new Parser();

    public static ExpenseList expenseList = new ExpenseList();

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());

        String input = in.nextLine();
        while(!input.equals("exit")) {
            switch (parser.extractCommandKeyword(input)) {
            case "add":
                expenseList.addExpense(input);
                break;
            case "delete":
                expenseList.deleteExpense(input);
                break;
            case "list":
                System.out.println("Here are the tasks in your list:\n");
                ExpenseList.listExpense();
                break;
            default:
                System.out.println("Unknown command.");
                break;
            }
            input = in.nextLine();
        }
    }
}
