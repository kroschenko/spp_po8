namespace sppLab4z3;


public class Exam
{
    public static List<Exam> Exams = new List<Exam>();
    
    public string Title { get; }
    public Teacher Teacher { get; }
    public List<Enrollee> Enrollees { get; set; }

    public int MaxGrade { get; }
    
    public Exam(string title, Teacher teacher,  int maxGrade)
    {
        Title = title;
        Teacher = teacher;
        Enrollees = new List<Enrollee>();
        MaxGrade = maxGrade;
    }

    public static void CheckAllExams()
    {
        foreach (var exam in Exams)
        {
            exam.Teacher.ExamCheck(exam);
        }
    }
    
    
}

public class Enrollee
{
    public static List<Enrollee> Enrollees = new();
    public string FirstName { get; }
    public string SecondName { get; }
    public List<Grade> Grades { get; set; }
    
    public double AvgGrades { get; set; }
    
    public Enrollee(string firstName, string secondName)
    {
        FirstName = firstName;
        SecondName = secondName;
        Grades = new List<Grade>();
        AvgGrades = 0;
    }

    public static void PassAllExams()
    {
        foreach (var enrollee in Enrollees)
        {
            enrollee.PassExam();
        }
    }

    public static void PrintAllEnrollees()
    {
        foreach (var enrollee in Enrollees)
        {
            Console.WriteLine(enrollee);
        }
    }
    public void Register(string facultyTitle)
    {
        foreach (var faculty in Faculty.Faculties)
        {
            if (faculty.Title == facultyTitle)
            {
                faculty.Enrollees.Add(this);
                foreach (var neededExamTitle in faculty.NeededExamTitles)
                {
                    RegisterOnExam(neededExamTitle);
                }
            }
        }
    }

    public void RegisterOnExam(string examTitle)
    {
        foreach (var exam in Exam.Exams)
        {
            if (exam.Title == examTitle)
            {
                exam.Enrollees.Add(this);
            }
        }
    }

    public void PassExam()
    {
        Console.WriteLine($"{FirstName} {SecondName} pass all exams");
    }

    public override string ToString()
    {
        string output = $"{FirstName} {SecondName} ";
        foreach (var grade in Grades)
        {
            output += $"{grade} ";
        }

        output += $"Avg: {AvgGrades}";
        return output;
    }
}

public class Faculty
{
    public static List<Faculty> Faculties = new List<Faculty>();
    public string Title { get; }
    public int NumOfStudent { get; }
    
    public string[] NeededExamTitles { get; }
    public List<Enrollee> Enrollees { get; set; }
    
    public Faculty(string title, int numOfStudent, string[] neededExamTitles)
    {
        Title = title;
        NumOfStudent = numOfStudent;
        NeededExamTitles = neededExamTitles;
        Enrollees = new List<Enrollee>();
    }

    public static void CountAllEnrollesAvg()
    {
        foreach (var faculty in Faculties)
        {
            faculty.CountAvg();
        }
    }

    public static void GetAllResultLists()
    {
        foreach (var faculty in Faculties)
        {
            faculty.GetResultList();
        }
    }

    public void GetResultList()
    {
        Console.WriteLine($"{Title}:");
        Enrollees.Sort((x, y) => y.AvgGrades.CompareTo(x.AvgGrades));
        for (int i = 0; i < NumOfStudent; i++)
        {
            Console.WriteLine(Enrollees[i]);
        }
    }
    
    public void CountAvg()
    {
        foreach (var enrollee in Enrollees)
        {
            int sum = 0;
            foreach (var grade in enrollee.Grades)
            {
                sum += grade.Score;
            }

            enrollee.AvgGrades = ((double)sum) / enrollee.Grades.Count;
        }
    }
}

public class Teacher
{
    public static List<Teacher> Teachers = new List<Teacher>();
    public string FirstName { get; }
    public string SecondName { get; }
    
    public Teacher(string firstName, string secondName)
    {
        FirstName = firstName;
        SecondName = secondName;
    }
    
    public void ExamCheck(Exam exam)
    {
        Random random = new Random();
        foreach (var enrollee in exam.Enrollees)
        {
            enrollee.Grades.Add(new Grade(random.Next(exam.MaxGrade),exam.Title));
        }
    }
}

public class Grade
{
    public string ExamTitle { get; }
    public int Score { get; }
    
    public Grade(int score, string examTitle)
    {
        Score = score;
        ExamTitle = examTitle;
    }

    public override string ToString()
    {
        return $"{ExamTitle}: {Score}";
    }
}