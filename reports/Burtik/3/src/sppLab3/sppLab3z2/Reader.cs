namespace sppLab3z2;

public class Reader
{
    private static List<Reader> _readers = new List<Reader>();
    private int _id;
    private string _name;
    private List<Book> _books;
    private List<DateTime> _dateTimes;
    
    public Reader(int id, string name)
    {
        _id = id;
        _name = name;
        _books = new List<Book>();
        _dateTimes = new List<DateTime>();
    }
    public Reader(int id, string name, List<Book> books, List<DateTime> dateTimes)
    {
        _id = id;
        _name = name;
        _books = books;
        _dateTimes = dateTimes;
    }

    public static void ReadFromFile(string path)
    {
        string[] input;
        using (StreamReader reader = new StreamReader(path))
        {
            input = reader.ReadToEnd().Split("\n");
        }

        foreach (var str in input)
        {
            string[] data = str.Split("~");
            int id = Convert.ToInt32(data[0]);
            string name = data[1];
            int numOfBook = Convert.ToInt32(data[2]);
            List<int> booksId = new List<int>();
            List<DateTime> dateTimes = new List<DateTime>();
            for (int i = 0; i < numOfBook; i++)
            {
                booksId.Add(Convert.ToInt32(data[i+3])); 
                dateTimes.Add(Convert.ToDateTime(data[i+numOfBook+3]));
            }
            List<Book> books = new List<Book>();
            foreach (var i in booksId)
            {
                books.Add(Book.GetBook(i));
            }
            _readers.Add(new Reader(id,name,books,dateTimes));
        }
    }

    public static void ShowBook()
    {
        foreach (var reader in _readers)
        {
            foreach (var book in reader._books)     
            {
                Console.WriteLine(book);
            }
        }
    }
    
    public static void ShowBookAndReaderData()
    {
        foreach (var reader in _readers)
        {
            foreach (var book in reader._books)     
            {
                Console.WriteLine($"{book}, Reader: {reader._id}|{reader._name}");
            }
        }
    }
    public static void ShowDelayBook()
    {
        foreach (var reader in _readers)
        {
            int index = 0;
            foreach (var book in reader._books)     
            {
                if (reader._dateTimes[index] < DateTime.Now)
                {
                    Console.WriteLine($"{book}, Reader: {reader._id}|{reader._name}");
                }

                index++;
            }
        }
    }
    
    public void AddBook(Book book, DateTime dateTime)
    {
        _books.Add(book);
        _dateTimes.Add(dateTime);
    }
}