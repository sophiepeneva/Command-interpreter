# Command-interpreter

public class CommandInterpreter {
    private String command;
    private String words;
    public CommandInterpreter(String command)
    {
        this.command = command;
        this.separateWords();
        this.getAction();
    }
    public CommandInterpreter()
    {
        this.command = "No command";
        this.words = "No words";
    }
    String getCommand() { return command; }
    String getWords() { return words; }
    public void setCommand(String command)
    {
        this.command=command;
        this.separateWords();
        this.getAction();
    }
    public void setWords(String words){ this.words=words; }
    public String getAction()
    {
        String action = new String();
        int length = this.command.length();
        for (int i = 0; i < length; i++) {
            if(this.command.charAt(i)!=' ')
            {
                action = action + command.charAt(i);
            }
            else { i = length; }
        }
    return action;
    }
    public void separateWords()
    {
        String wholeCommand = command;
        String separatedWords = new String();
        int length = wholeCommand.length();
        boolean actionRead = false;
        for (int i = 0; i < length; i++) {
            if(wholeCommand.charAt(i)==' '&&actionRead==false)
            {
                i++;
                actionRead = true;
            }
            if(actionRead==true)
            {
                separatedWords = separatedWords + wholeCommand.charAt(i);
            }
        }
        words = separatedWords;
    }
}
