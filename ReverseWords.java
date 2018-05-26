# Command-interpreter

public class ReverseWords extends CommandInterpreter {
    public ReverseWords(String command, String words)
    {
        setCommand(command);
        setWords(words);
    }
    public ReverseWords()
    {
        setCommand("reverse-words ");
        setWords("");
    }
    public String ReverseOrder()
    {
        String reversedWords = new String();
        Reverse r1 = new Reverse(this.getCommand(), this.getWords());
        String reverse = r1.Reverse();
        int length = reverse.length();
        String word = new String();
        for (int i = 0; i < length; i++)
        {
            if(reverse.charAt(i)!=' ')word=word+reverse.charAt(i);
            if(reverse.charAt(i)==' '||i==length-1)
            {
                r1.setWords(word);
                reversedWords = reversedWords + r1.Reverse() + " ";
                word = new String();
            }
        }
        return reversedWords;
    }
}
