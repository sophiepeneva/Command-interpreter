# Command-interpreter

public class CountWords extends CommandInterpreter {
    public CountWords(String command, String words)
    {
        setCommand(command);
        setWords(words);
    }
    public CountWords()
    {
        setCommand( "count-words ");
        setWords("");
    }
    public int getNumberOfWords()
    {
        int length = getWords().length();
        int spaceCounter=0;
        for (int i = 0; i < length; i++) {
            if(getWords().charAt(i)==' ')spaceCounter++;
        }
        if(spaceCounter>0)spaceCounter++;
        return spaceCounter;
    }
}
