using sppLab4z3;

#region Faculties

Faculty.Faculties.Add(new Faculty("DESK",3, ["Math","DB","SPP"]));
Faculty.Faculties.Add(new Faculty("WEB",3, ["Math","DB","WT"]));

#endregion

#region Teachers


Teacher.Teachers.Add(new Teacher("t1F","t1S"));
Teacher.Teachers.Add(new Teacher("t2F","t2S"));
Teacher.Teachers.Add(new Teacher("t3F","t3S"));


#endregion

#region Exams

Exam.Exams.Add(new Exam("Math",Teacher.Teachers[0],100));
Exam.Exams.Add(new Exam("SPP",Teacher.Teachers[1],100));
Exam.Exams.Add(new Exam("DB",Teacher.Teachers[2],100));
Exam.Exams.Add(new Exam("WT",Teacher.Teachers[2],100));

#endregion

#region Enrollees


Enrollee.Enrollees.Add(new Enrollee("e1F","e1S"));
Enrollee.Enrollees.Add(new Enrollee("e2F","e2S"));
Enrollee.Enrollees.Add(new Enrollee("e3F","e3S"));
Enrollee.Enrollees.Add(new Enrollee("e4F","e4S"));
Enrollee.Enrollees.Add(new Enrollee("e5F","e5S"));
Enrollee.Enrollees.Add(new Enrollee("e6F","e6S"));
Enrollee.Enrollees.Add(new Enrollee("e7F","e7S"));
Enrollee.Enrollees.Add(new Enrollee("e8F","e8S"));
Enrollee.Enrollees.Add(new Enrollee("e9F","e9S"));
Enrollee.Enrollees.Add(new Enrollee("e10F","e10S"));
Enrollee.Enrollees.Add(new Enrollee("e11F","e11S"));
Enrollee.Enrollees.Add(new Enrollee("e12F","e12S"));

for (int i = 0; i < 5; i++)
{
    Enrollee.Enrollees[i].Register("DESK");
}

for (int i = 5; i < 12; i++)
{
    Enrollee.Enrollees[i].Register("WEB");
}

#endregion

Enrollee.PassAllExams();
Exam.CheckAllExams();
Faculty.CountAllEnrollesAvg();
Enrollee.PrintAllEnrollees();
Faculty.GetAllResultLists();




