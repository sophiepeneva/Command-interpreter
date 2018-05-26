# Command-interpreter

ublic class Reverse extends CommandInterpreter {
    public Reverse(String command, String words)
    {
        setCommand(command);
        setWords(words);
    }
    public Reverse()
    {
        setCommand("reverse ");
        setWords("");
    }
    public String Reverse()
    {
        String reversedWord = new String();
        int length = getWords().length();
        for (int i = length - 1; i >= 0; i--)
        {
            reversedWord = reversedWord + getWords().charAt(i);
        }
        return reversedWord;
    }
}
