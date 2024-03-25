
interface IDigitalClock
{
    void DisplayTime(int hour, int minute);
}

class AnalogClock
{
    private int hour;
    private int minute;

    public AnalogClock(int hour, int minute)
    {
        this.hour = hour;
        this.minute = minute;
    }

    private double CalculateHourHandAngle()
    {
        return (hour % 12 + minute / 60.0) * 360 / 12;
    }

    private double CalculateMinuteHandAngle()
    {
        return minute * 360 / 60;
    }

    public void DisplayTime()
    {
        Console.WriteLine($"Analog clock shows the time: {hour}:{minute}");
        Console.WriteLine($"Angle of the hour hand: {CalculateHourHandAngle()} degrees");
        Console.WriteLine($"Angle of the minute hand: {CalculateMinuteHandAngle()} degrees");
    }
}

class AnalogToDigitalAdapter : IDigitalClock
{
    private AnalogClock analogClock;

    public AnalogToDigitalAdapter(AnalogClock analogClock)
    {
        this.analogClock = analogClock;
    }

    public void DisplayTime(int hour, int minute)
    {
        analogClock.DisplayTime();
    }
}

class Program
{
    static void Main(string[] args)
    {
        AnalogClock analogClock = new AnalogClock(10, 30);
        IDigitalClock adapter = new AnalogToDigitalAdapter(analogClock);
        adapter.DisplayTime(10, 30);
    }
}
