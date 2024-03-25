if (args.Length != 3)
{
    Console.WriteLine("Error");
    return;
}

double argsA = Convert.ToDouble(args[0]);
double argsB = Convert.ToDouble(args[1]);

int argsSize = Convert.ToInt32(args[2]);


var array = GenerateArray(argsA,argsB,argsSize);
for (int i = 0; i < argsSize; i++)
{
    for (int j = 0; j < argsSize; j++)
    {
        Console.Write($"{array[i,j]} ");
    }
    Console.WriteLine();
}
Console.ReadLine();


double[,] GenerateArray(double a, double b, int size)
{
    Random random = new Random();
    double[,] arr = new double[size,size];
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
        {
            arr[i, j] = random.NextDouble() * (b-a) + a;
            if (arr[i, j] < a)
            {
                arr[i, j] = a;
            }
            else if (arr[i, j] > b)
            {
                arr[i, j] = b;
            }
        }
    }

    return arr;
}