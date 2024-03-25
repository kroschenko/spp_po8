if (args.Length < 1)
{
    Console.WriteLine("error");
    return;
}

Console.WriteLine(SwapString(args[0]));

string SwapString(string str)
{
    string resultStr = "";
    for (int i = 0; i < str.Length; i++)
    {
        if (char.IsUpper(str, i))
        {
            resultStr += char.ToLower(str[i]);
        }
        else
        {
            resultStr += char.ToUpper(str[i]);
        }
    }
    return resultStr;
}