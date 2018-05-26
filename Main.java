# Command-interpreter

import java.util.*;
public class Main {
    public static void main(String[] args) {
        CommandInterpreter ci = new CommandInterpreter();
        while (true) {
            System.out.println("Enter a command");
            Scanner user_input = new Scanner(System.in);
            String command = user_input.nextLine();
            ci.setCommand(command);
            String action = ci.getAction();
            if (action.compareTo("reverse") == 0) {
                Reverse r1 = new Reverse(ci.getCommand(), ci.getWords());
                System.out.println(r1.Reverse());
            }
            if (action.compareTo("count-words") == 0) {
                CountWords c1 = new CountWords(ci.getCommand(), ci.getWords());
                System.out.println(c1.getNumberOfWords());
            }
            if (action.compareTo("reverse-words") == 0) {
                ReverseWords rw1 = new ReverseWords(ci.getCommand(),ci.getWords());
                System.out.println(rw1.ReverseOrder());
            }
        }
    }
}
