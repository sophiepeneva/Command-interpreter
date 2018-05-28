# Command-interpreter

public class Get extends CommandInterpreter {
    public Get(String command, String words)
    {
        setCommand(command);
        setWords(words);
    }

    public String Get(CommandInterpreter ci)
    {
        String valueVar = new String();
        int length = ci.getNumOfVars();
        for (int i = 0; i < length; i++) {
            if(ci.getVar(i).getName().compareTo(this.getWords())==0)
            {
                valueVar = "["+ ci.getVar(i).getType()+"] "+ci.getVar(i).getValue();
            }
        }
        return valueVar;
    }
}
