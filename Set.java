# Command-interpreter

public class Set extends CommandInterpreter {
    private String variable;
    private String type;
    private String value;
    public Set(String command, String words)
    {
        setCommand(command);
        setWords(words);
        setType();
        setVariable();
        setValue();
    }
    public Set()
    {
        setWords("");
        setCommand("set");
        type=" ";
        variable=" ";
        value=" ";
    }
    public void setVariable()
    {
        variable = new String();
        int length = getWords().length();
        for (int i = 0; i < length; i++)
        {
            if(getWords().charAt(i) != ' ')variable += getWords().charAt(i);
            else{ i = length; }
        }
    }
    public void setType()
    {
        type = new String();
        int length = getWords().length();
        boolean startSetting = false;
        for (int i = 0; i < length; i++)
        {
            if(getWords().charAt(i) == ' ' && startSetting == false) {
                startSetting = true;
                i++;
            }
            if(startSetting == true)
            {
                if (getWords().charAt(i) != ' ') type = type +  getWords().charAt(i);
                if(getWords().charAt(i)==' ')i=length;
            }
        }
    }
    public void setValue()
    {
        value = new String();
        int length = getWords().length();
        int counterSpace = 0;
        for (int i = 0; i < length; i++)
        {
            if (getWords().charAt(i) == ' ')
            {
                counterSpace++;
                i++;
            }
            if (counterSpace == 2)
            {
                if (getWords().charAt(i) != ' ') value += getWords().charAt(i);
                else { i = length; }
            }
        }
    }
    public String getType(){ return type; }
    public String getVariable(){ return variable; }
    public String getValue(){ return value; }
    public String Set()
    {
        Variable var = new Variable();
        var.setName(variable);
        var.setValue(value);
        var.setType(type);
        addToVar(var);
        return "Ok";
    }
    public Variable getVars(){return getVar(0);}
}
