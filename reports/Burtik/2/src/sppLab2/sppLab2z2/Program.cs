int i = 1;
int l = 1;
string n = "ln";
string inputPath;
string outputPath = "-";
if (args.Contains("-i"))
{
    int iIndex = Array.IndexOf(args, "-i");
    i = Convert.ToInt32(args[iIndex + 1]);
}

if (args.Contains("-l"))
{
    int lIndex = Array.IndexOf(args, "-l");
    l = Convert.ToInt32(args[lIndex + 1]);
}

if (args.Contains("-n"))
{
    int nIndex = Array.IndexOf(args, "-n");
    n = args[nIndex + 1];
}

if (args.Length % 2 == 0)
{
    inputPath = args[^2];
    outputPath = args[^1];
}
else
{
    inputPath = args[^1];
}
/*
Console.WriteLine($"-i {i}\n" +
                  $"-l {l}\n" +
                  $"-n {n}\n" +
                  $"path1 {inputPath}\n" +
                  $"path2 {outputPath}");
*/                
List<string> list = new List<string>();
using (StreamReader reader = new StreamReader(inputPath))
{
    int index = 1;
    string[] str = reader.ReadToEnd().Split("\n");
    int count = str.Length;
    for (int j = 0; j < str.Length; j++)
    {
        str[j] = str[j].Trim();
        if (str[j] == "")
        {
            if (l == 1)
            {
                str[j] = AddIndex(str[j], index, count, n);
            }
            else
            {
                index -= i;
            }
        }
        else
        {
            str[j] = AddIndex(str[j], index, count, n);
        }
        list.Add(str[j]);
        index += i;
    }
}
    
if (outputPath == "-")
{
    foreach (var str in list)
    {
        Console.WriteLine(str);
    }
}
else
{
    using (StreamWriter writer = new StreamWriter(outputPath))
    {
        foreach (var str in list)
        {
            writer.WriteLine(str);
        }
    }
}

Console.ReadLine();

string AddIndex(string str, int index, int count, string type)
{
    switch (type)
    {
        case "ln":
            return $"{index}. {str}";
        case "rn":
            string s1 = "";
            for (int j = 0; j < count.ToString().Length - index.ToString().Length ; j++)
            {
                s1 += " ";
            }
            return $"{s1}{index}. {str}";
        case "rz":
            string s2 = "";
            for (int j = 0; j < count.ToString().Length - index.ToString().Length ; j++)
            {
                s2 += "0";
            }
            return $"{s2}{index}. {str}";
    }

    return "";
}
