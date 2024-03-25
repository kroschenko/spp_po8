int col1 = 1;
int col2 = 1;
string fileName1, fileName2;
string? fileName3 = null;


int numOfArgs = 0;
if (args.Contains("-1"))
{
    int iIndex = Array.IndexOf(args, "-1");
    col1 = Convert.ToInt32(args[iIndex + 1]);
    numOfArgs += 2;
}

if (args.Contains("-2"))
{
    int lIndex = Array.IndexOf(args, "-2");
    col2 = Convert.ToInt32(args[lIndex + 1]);
    numOfArgs += 2;
}

if ((args.Length - numOfArgs) % 2 == 0)
{
    fileName1 = args[^2];
    fileName2 = args[^1];
}
else
{
    fileName1 = args[^3];
    fileName2 = args[^2];
    fileName3 = args[^1];
}

List<string[]> fileData1 = ReadData(fileName1);
List<string[]> fileData2 = ReadData(fileName2);
List<string[]> fileData3 = new List<string[]>();

foreach (var row1 in fileData1)
{
    foreach (var row2 in fileData2)
    {
        if (row1[col1] == row2[col2])
        {
            fileData3.Add(JoinData(row1, row2, col1, col2));
        }
    }
}

if (fileName3 != null)
{
    using (StreamWriter writer = new StreamWriter(fileName3))
    {
        foreach (var str in fileData3)
        {
            foreach (var s in str)
            {
                writer.Write($"{s} ");
            }
            writer.WriteLine();
        }
    }
}
else
{
    foreach (var str in fileData3)
    {
        foreach (var s in str)
        {
            Console.Write($"{s} ");
        }
        Console.WriteLine();
    }
}


string[] JoinData(string[] str1, string[] str2, int col1, int col2)
{
    string[] strings = new string[str1.Length + str2.Length - 1];
    strings[0] = str1[col1];
    int index = 1;
    for (int i = 0; i < str1.Length; i++)
    {
        if (i == col1)
            continue;
        strings[index] = str1[i];
        index++;
    }

    for (int i = 0; i < str2.Length; i++)
    {
        if (i == col2)
            continue;
        strings[index] = str2[i];
        index++;
    }

    return strings;
}


List<string[]> ReadData(string fileName)
{
    List<string[]> fileData = new List<string[]>();
    using (StreamReader reader = new StreamReader(fileName))
    {
        string[] str = reader.ReadToEnd().Trim().Split("\n");
        foreach (var s in str)
        {
            string[] strings = s.Trim().Split(" ");
            fileData.Add(strings);
        }
    }

    return fileData;
}
