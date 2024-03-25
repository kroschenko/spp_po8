using sppLab3z2;

Book.ReadFromFile("books.txt");
Console.WriteLine("All books:");
Book.ShowAllBooks();
Console.WriteLine("Show book older when 10 year:");
Book.ShowBookOlder(10);
Console.WriteLine("Show reader's books");
Reader.ReadFromFile("readers.txt");
Reader.ShowBook();
Console.WriteLine("Show books and reader's data:");
Reader.ShowBookAndReaderData();
Console.WriteLine("Delay:");
Reader.ShowDelayBook();