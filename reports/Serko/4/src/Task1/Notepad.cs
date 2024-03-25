using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task1
{
    public class Notepad
    {

        private class Note
        {
            public DateTime Date { get; }
            public string Text { get; }

            public Note(DateTime date, string text)
            {
                Date = date;
                Text = text;
            }
        }

        private Dictionary<DateTime, List<Note>> notes;

        public Notepad()
        {
            notes = new Dictionary<DateTime, List<Note>>();
        }

        public void AddNote(DateTime date, string text)
        {
            if (!notes.ContainsKey(date))
            {
                notes[date] = new List<Note>();
            }

            notes[date].Add(new Note(date, text));
        }

        public List<string> FindNotes(DateTime date)
        {
            if (notes.ContainsKey(date))
            {
                List<string> foundNotes = new List<string>();
                foreach (var note in notes[date])
                {
                    foundNotes.Add(note.Text);
                }
                return foundNotes;
            }
            else
            {
                return new List<string>();
            }
        }

        public void PrintAllNotes()
        {
            foreach (var entry in notes)
            {
                Console.WriteLine($"Date: {entry.Key.ToShortDateString()}");
                foreach (var note in entry.Value)
                {
                    Console.WriteLine($"- {note.Text}");
                }
                Console.WriteLine();
            }
        
    }

}
}
