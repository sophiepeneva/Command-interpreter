# Command-interpreter

public class CommandInterpreter {
    private String command;
    private String words;
    private Variable vars[];
    private int numOfVars;
    public CommandInterpreter(String command)
    {
        this.command = command;
        this.separateWords();
        this.getAction();
        vars = new Variable[0];
        numOfVars=0;
    }
    public void setTypeAndValueByName(Variable var)
    {
        for (int i = 0; i < numOfVars; i++) {
            if(var.getName().compareTo(vars[i].getName())==0)
            {
                var.setValue(vars[i].getValue());
                var.setType(vars[i].getType());
            }
        }

    }
    public int getNumOfVars(){return numOfVars;}
    public void addToVar(Variable var) {
        int length = numOfVars;
        boolean hasItAlready = false;
        for (int i = 0; i < length; i++) {
            if(vars[i].getName().compareTo(var.getName())==0)
            {
                hasItAlready=true;
                System.out.println(var.getValue());
                vars[i].setValue(var.getValue());
            }
        }
        if(hasItAlready==false) {
            Variable[] temp = new Variable[length];
            for (int i = 0; i < length; i++) {
                temp[i] = vars[i];
            }
            vars = new Variable[length + 1];
            for (int i = 0; i < length; i++) {
                vars[i] = temp[i];
            }
            vars[length] = new Variable();
            vars[length].setName(var.getName());
            vars[length].setValue(var.getValue());
            vars[length].setType(var.getType());
            numOfVars++;
        }
    }

    public Variable getVar(int i){return vars[i];}

    public void displayVars()
    {
        for (int i = 0; i < numOfVars; i++) {
            System.out.println(vars[i].getName()+"="+vars[i].getValue()+" and is a "+vars[i].getType());
        }

    }
    public CommandInterpreter()
    {
        this.command = "No command";
        this.words = "No words";
        vars = new Variable[0];
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
