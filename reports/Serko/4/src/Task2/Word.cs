using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Task2;
namespace Task2
{
    internal class Word
    {
        private string word;

        public Word(string word)
        {
            this.word = word;
        }

        public int Length()
        {
            return word.Length;
        }

        public string GetWord()
        {
            return word;
        }
    }

}
