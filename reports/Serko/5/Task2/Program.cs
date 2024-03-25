


abstract class MusicalInstrument
{
    protected string Name;

    public MusicalInstrument(string name)
    {
        Name = name;
    }

    public abstract void Play();
}

class Percussion : MusicalInstrument
{
    public Percussion(string name) : base(name)
    {
    }

    public override void Play()
    {
        Console.WriteLine(Name + " plays percussion rhythms");
    }
}

class Stringed : MusicalInstrument
{
    public Stringed(string name) : base(name)
    {
    }

    public override void Play()
    {
        Console.WriteLine(Name + " plays string melodies");
    }
}

 class Wind : MusicalInstrument
{
    public Wind(string name) : base(name)
    {
    }

    public override void Play()
    {
        Console.WriteLine(Name + " plays wind melodies");
    }
}

class Orchestra
{
    private MusicalInstrument[] Instruments;

    public Orchestra(MusicalInstrument[] instruments)
    {
        Instruments = instruments;
    }

    public void DisplayComposition()
    {
        Console.WriteLine("Orchestra composition:");
        foreach (MusicalInstrument instrument in Instruments)
        {
            instrument.Play();
        }
    }
}

class Program
{
    static void Main(string[] args)
    {
        MusicalInstrument[] instruments = {
            new Stringed("Violin"),
            new Percussion("Drum"),
            new Wind("Trumpet"),
            new Stringed("Guitar")
        };

        Orchestra orchestra = new Orchestra(instruments);
        orchestra.DisplayComposition();
    }
}
