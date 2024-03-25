namespace sppLab4z1;

public class Session
{
    public Session(string name)
    {
        _tests = new List<Test>();
        Name = name;
    }

    public string Name { get; set; }
    private List<Test> _tests;

    public void PrintSession()
    {
        Console.WriteLine($"Title: {Name}");
        foreach (var test in _tests)
        {
            test.Print();
        }
    }
    public void AddExam(string title, string firstName, string secondName)
    {
        _tests.Add(new Exam(title,firstName,secondName, -1));
    }
    
    public void AddCredit(string title,string firstName, string secondName)
    {
        _tests.Add(new Credit(title,firstName,secondName, false));
    }

    public void SetScore(string title,object result)
    {
        foreach (var test in _tests)
        {
            if (test.Title == title)
            {
                if (test is Exam)
                {
                    ((Exam)test).Score = (int)result;
                }
                else
                {
                    ((Credit)test).Result = (bool)result;
                }
            }
        }
    }
}

public abstract class Test
{
    public string Title {  get; set; }
    protected string TeacherFirstName { get; set; }
    protected string TeacherSecondName { get; set; }

    public abstract void Print();
}

public class Credit : Test
{
    public Credit(string title,string teacherFirstName, string teacherSecondName,bool result)
    {
        Title = title;
        TeacherFirstName = teacherFirstName;
        TeacherSecondName = teacherSecondName;
        Result = result;
    }

    public bool Result { get; set; }

    public override void Print()
    {
        string str = Result ? "Passed" : "Not passed";
        Console.WriteLine($"{Title}({TeacherFirstName} {TeacherSecondName}) - {str}");
    }
}
public class Exam : Test
{
    public Exam(string title, string teacherFirstName, string teacherSecondName,int score)
    {
        Title = title;
        TeacherFirstName = teacherFirstName;
        TeacherSecondName = teacherSecondName;
        Score = score;
    }

    public int Score { get; set; }
    public override void Print()
    {
        Console.WriteLine($"{Title}({TeacherFirstName} {TeacherSecondName}) - {Score}");
    }
}
