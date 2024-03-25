namespace sppLab4z1;

public class CreditBook
{
    private int _id;
    private string _firstName;
    private string _secondName;
    public List<Session> _sessions { get; }
    
    public CreditBook(int id, string firstName, string secondName)
    {
        _id = id;
        _firstName = firstName;
        _secondName = secondName;
        _sessions = new List<Session>();
    }

    public void AddSession(string name)
    {
        _sessions.Add(new Session(name));
    }

    public void PrintAllSession()
    {
        foreach (var session in _sessions)
        {
            session.PrintSession();
        }
    }
    
    public void AddTest(string sessionTitle, string title, string firstName, string secondName, bool type /*true - exam, false - credit*/)
    {
        foreach (var session in _sessions)
        {
            if (session.Name == sessionTitle)
            {
                if (type)
                {
                    session.AddExam(title,firstName,secondName);
                }
                else
                {
                    session.AddCredit(title,firstName,secondName);
                }
            }
        }
    }
    
    
    public void SetScore(string sessionTitle, string title, object score)
    {
        foreach (var session in _sessions)
        {
            if (session.Name == sessionTitle)
            {
                if (score is int || score is bool)
                {
                    session.SetScore(title,score);
                }
                else
                {
                    Console.WriteLine("Wrong type of score");
                }
            }
        }
    }
}