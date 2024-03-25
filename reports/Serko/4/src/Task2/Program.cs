using Task2;

   List<Line> linesOnPage = new List<Line>();
    Page page = new Page(linesOnPage);

Console.WriteLine("Enter words for a line (separated by space), or type 'done' to finish:");

bool addingWords = true;
    while (addingWords)
    {
        string input = Console.ReadLine();
        if (input.ToLower() == "done")
        {
            addingWords = false;
        }
        else
        {
            List<Word> wordsInLine = new List<Word>();
            string[] wordStrings = input.Split(' ');
            foreach (string wordString in wordStrings)
            {
                wordsInLine.Add(new Word(wordString));
            }
            Line line = new Line(wordsInLine);
            page.AddLine(line);
        }
    }

    Console.WriteLine("Number of lines on the page: " + page.LineCount());

