using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

class Program
{
    static void Main()
    {
        string text = File.ReadAllText("test.txt");

        Dictionary<string, int> wordDict = new Dictionary<string, int>();

        string[] words = text.Split(new char[] { ' ', '.', ',', ';', ':', '!', '?' }, StringSplitOptions.RemoveEmptyEntries);

        foreach (string word in words)
        {
            if (wordDict.ContainsKey(word))
            {
                wordDict[word]++;
            }
            else
            {
                wordDict[word] = 1;
            }
        }

        var sortedWords = wordDict.OrderByDescending(pair => pair.Value);

        foreach (var pair in sortedWords)
        {
            Console.WriteLine($"Word: {pair.Key}, Frequency: {pair.Value}");
        }
    }
}
