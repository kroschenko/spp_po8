using sppLab4z1;

CreditBook burtikCB = new CreditBook(1,"Yakov","Burtik");
burtikCB.AddSession("S1");
burtikCB.AddTest("S1","SPP","Alexandr","Kroschenko",false);
burtikCB.AddTest("S1","RMS","Xz","Kozinski",false);
burtikCB.AddTest("S1","EXAM1","ExamF","ExamS",true);
burtikCB.SetScore("S1","SPP",true);
burtikCB.SetScore("S1","RMS",false);
burtikCB.SetScore("S1","EXAM1",10);
burtikCB.PrintAllSession();