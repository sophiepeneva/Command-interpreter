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
            if(action.compareTo("set")==0){
                Set s1 = new Set(ci.getCommand(),ci.getWords());
                if(s1.getType().compareTo("number")==0||s1.getType().compareTo("String")==0)
                {
                    s1.Set();
                    ci.addToVar(s1.getVars());
                }
                else{ System.out.println("Err");}
            }
            if(action.compareTo("get")==0){
               Get g1 = new Get(ci.getCommand(),ci.getWords());
                System.out.println(g1.Get(ci));
            }
            if(action.compareTo("calc")==0){
                Calc c1 = new Calc(ci.getCommand(),ci.getWords(),ci);
                c1.Calc(ci);
            }
        }
    }
}

