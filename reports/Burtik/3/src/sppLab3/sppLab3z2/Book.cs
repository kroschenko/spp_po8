namespace sppLab3z2;

public class Book
{
    private static int _year = 2024;
    private static List<Book> _books = new List<Book>();
    private int _id;
    private string _authorName;
    private int _yearOfPublishing;
    private string _title;
    private int _numOfBooks;
    private int _numOfPage;
    private int _numOfVolume;

    public Book(int id, string authorName, int yearOfPublishing, string title, int numOfPage, int numOfVolume, int numOfBooks)
    {
        _id = id;
        _authorName = authorName;
        _yearOfPublishing = yearOfPublishing;
        _title = title;
        _numOfPage = numOfPage;
        _numOfVolume = numOfVolume;
        _numOfBooks = numOfBooks;
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
            _books.Add(new Book(
                Convert.ToInt32(data[0]),
                data[1],
                Convert.ToInt32(data[2]),
                data[3],
                Convert.ToInt32(data[4]),
                Convert.ToInt32(data[5]),
                Convert.ToInt32(data[6])));
        }
    }
    
    public static Book GetBook(int id)
    {
        foreach (var book in _books)
        {
            if (book._id == id)
            {
                return book;
            }
        }

        return null;
    }

    public static Book GetBook(string title)
    {
        foreach (var book in _books)
        {
            if (book._title == title)
            {
                return book;
            }
        }

        return null;
    }

    public static void ShowAllBooks()
    {
        foreach (var book in _books)
        {
            Console.WriteLine(book);
        }
    }

    public static void ShowBookOlder(int n)
    {
        foreach (var book in _books)
        {
            if (_year - book._yearOfPublishing > n)
            {
                Console.WriteLine(book);
            }
        }
    }
    
    public override string ToString()
    {
        return $"{_id}|{_title}|{_authorName}|{_yearOfPublishing}|{_numOfPage}|{_numOfVolume}|{_numOfBooks}";
    }
}