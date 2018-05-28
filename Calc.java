# Command-interpreter

public class Calc extends CommandInterpreter{
    private Variable[] varsG;
    private char operation;

    public Calc(String command, String words, CommandInterpreter ci)
    {
        setCommand(command);
        setWords(words);
        setMembers(ci);
    }
    public void setMembers(CommandInterpreter ci)
    {
        varsG = new Variable[3];
        for (int i = 0; i < 3; i++) {
            varsG[i] = new Variable();
        }
        int length = getWords().length();
        String names = new String();
        for (int i = 0; i < length ; i++) {
            while(getWords().charAt(i)!=' ')
            {
                names+=getWords().charAt(i);
                i++;
            }
            varsG[0].setName(names);
            names = new String();
            i++;
            while(getWords().charAt(i)!=' ')
            {
                names+=getWords().charAt(i);
                i++;
            }
            varsG[1].setName(names);
            names = new String();
            i++;
            operation = getWords().charAt(i);
            i+=2;
            while(i<length)
            {
                names+=getWords().charAt(i);
                i++;
            }
            varsG[2].setName(names);
        }
        ci.setTypeAndValueByName(varsG[0]);
        ci.setTypeAndValueByName(varsG[1]);
        ci.setTypeAndValueByName(varsG[2]);
    }
    public String Calc(CommandInterpreter ci)
    {
        Variable tempVar = new Variable();
        if(varsG[1].getType().compareTo("String")==0||varsG[2].getType().compareTo("String")==0)
        {
            tempVar.setType("String");
            tempVar.setName(varsG[0].getName());
            if(operation=='+') {
                tempVar.setValue(varsG[1].getValue() + varsG[2].getValue());
                ci.addToVar(tempVar);
            }
            if(operation=='*')
            {
                if(varsG[2].getType().compareTo("number")==0) {
                    int length = varsG[2].getValue().length();
                    int numValue = 0;
                    int dec = 1;
                    String timedValue = new String();
                    for (int i = 0; i < length; i++) {
                        numValue = numValue * dec + (varsG[2].getValue().charAt(i) - '0');
                        dec *= 10;
                    }
                    for (int i = 0; i < numValue; i++) {
                        timedValue += varsG[1].getValue();
                    }
                    tempVar.setValue(timedValue);
                    ci.addToVar(tempVar);
                }
                if(varsG[1].getType().compareTo("number")==0) {
                    int length = varsG[1].getValue().length();
                    int numValue = 0;
                    int dec = 1;
                    String timedValue = new String();
                    for (int i = 0; i < length; i++) {
                        numValue = numValue * dec + (varsG[1].getValue().charAt(i) - '0');
                        dec *= 10;
                    }
                    for (int i = 0; i < numValue; i++) {
                        timedValue += varsG[1].getValue();
                    }
                    tempVar.setValue(timedValue);
                    ci.addToVar(tempVar);
                }
                if(varsG[1].getType().compareTo("number")!=0&&varsG[2].getType().compareTo("number")!=0)return "Err";
            }
        }
        if(varsG[1].getType().compareTo("number")==0&&varsG[2].getType().compareTo("number")==0)
        {
            int first = Integer.parseInt(varsG[1].getValue());
            int second = Integer.parseInt(varsG[2].getValue());
            tempVar.setType("number");
            tempVar.setName(varsG[0].getName());
            if(operation=='+')tempVar.setValue(String.valueOf(first+second));
            if(operation=='-')tempVar.setValue(String.valueOf(first-second));
            if(operation=='*')tempVar.setValue(String.valueOf(first*second));
            ci.addToVar(tempVar);
        }
        return "Ok";
    }
}
