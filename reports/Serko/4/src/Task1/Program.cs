using Task1;

        Notepad myNotepad = new Notepad();
        myNotepad.AddNote(DateTime.Now, "Note 1");
        myNotepad.AddNote(DateTime.Now, "Note 2");
        myNotepad.AddNote(DateTime.Now.AddDays(1), "Note 3");
        List<string> todaysNotes = myNotepad.FindNotes(DateTime.Now);
        foreach (var note in todaysNotes)
        {
            Console.WriteLine("- " + note);
        }
        Console.WriteLine("All Notes:");
        myNotepad.PrintAllNotes();
