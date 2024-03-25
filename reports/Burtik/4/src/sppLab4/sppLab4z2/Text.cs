namespace sppLab4z2;

public class Text
{
    public List<Page> Pages;
    
    public Text()
    {
        Pages = new List<Page>();
    }

    public void Add(Page page)
    {
        Pages.Add(page);
    }

    public void Remove()
    {
        Pages.RemoveAt(Pages.Count - 1);
    }

    public void Print()
    {
        foreach (Page page in Pages)
        {
            Console.WriteLine($"Page {page.Number}:");
            page.Print();
        }
    }
    
}

public class Word
{
    string _word;
    private ConsoleColor _consoleColor;

    public Word(string str, ConsoleColor consoleColor = ConsoleColor.Gray)
    {
        _word = str;
        _consoleColor = consoleColor;
    }

    public void Print()
    {
        Console.ForegroundColor = _consoleColor;
        Console.Write(_word);
        Console.ResetColor();
    }

    public void EditWord(string str)
    {
        _word = str;
    }

    public void EditColor(ConsoleColor consoleColor)
    {
        _consoleColor = consoleColor;
    }

}

public class Page
{
    public List<Word> Words;
    public int Number { get; }
    
    public Page(int number)
    {
        Words = new List<Word>();
        Number = number;
    }

    public void Add(Word word)
    {
        Words.Add(word);
    }

    public void Remove()
    {
        Words.RemoveAt(Words.Count - 1);
    }

    public void Print()
    {
        foreach (Word word in Words)
        {
            word.Print();
        }
    }
}
