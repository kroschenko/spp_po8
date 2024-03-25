string path = "input.txt";
Dictionary<string, int> dictionary = new Dictionary<string, int>();
using (StreamReader reader = new StreamReader(path))
{
    string[] strings = reader.ReadToEnd().Split(',',' ','.');
    foreach (var str in strings)
    {
        if (dictionary.ContainsKey(str))
        {
            dictionary[str]++;
        }
        else
        {
            dictionary.Add(str,1);
        }
    }
}

var ordered = 
    dictionary.OrderByDescending(x => x.Value).
        ToDictionary(x => x.Key, x => x.Value);;


foreach (var dictItem in ordered)    
{
    Console.WriteLine($"{dictItem.Key} {dictItem.Value}");
}