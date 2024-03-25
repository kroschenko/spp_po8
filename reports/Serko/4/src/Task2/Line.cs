using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Task2;

namespace Task2
{
    internal class Line
    {
        private List<Word> words;

        public Line(List<Word> words)
        {
            this.words = words;
        }

        public int WordCount()
        {
            return words.Count;
        }

        public List<Word> GetWords()
        {
            return words;
        }

        public void AddWord(Word word)
        {
            words.Add(word);
        }
    }
}
