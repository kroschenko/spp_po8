using sppLab4z2;

Text text = new Text();

for (int i = 0; i < 4; i++)
{
    Page page = new Page(i+1);
    for (int j = 0; j < 10; j++)
    {
        page.Add(new Word($"str{j}\n",ConsoleColor.Green));
    }
    text.Add(page);
}

text.Pages[0].Remove();
text.Pages[0].Words[0].EditWord("edited word\n");
text.Pages[0].Words[0].EditColor(ConsoleColor.Red);

text.Remove();
text.Print();
