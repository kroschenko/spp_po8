namespace sppLab5z2;

public abstract class Transporter
{
    public abstract double CostPerDist { get; set; }
    public abstract double Speed { get; set; }
    public abstract double CalcCost(int dist);
    public abstract double CalcCost(string start,string end);
    public abstract double CalcTime(int dist);
    public abstract double CalcTime(string start,string end);
    
}

public class Airplane : Transporter
{
    public override double CostPerDist { get; set; }
    public override double Speed { get; set; }

    public override double CalcCost(int dist)
    {
        return dist * CostPerDist;
    }

    public override double CalcCost(string start,string end)
    {
        return ((double)DistInfo.GetDistance(start,end)) * CostPerDist;
    }

    public override double CalcTime(int dist)
    {
        return dist/Speed;
    }

    public override double CalcTime(string start,string end)
    {
        return DistInfo.GetDistance(start, end) / Speed;
    }
}

public class Train : Transporter
{
    public override double CostPerDist { get; set; }
    public override double Speed { get; set; }

    public override double CalcCost(int dist)
    {
        return dist * CostPerDist;
    }

    public override double CalcCost(string start,string end)
    {
        return ((double)DistInfo.GetDistance(start,end)) * CostPerDist;
    }

    public override double CalcTime(int dist)
    {
        return dist/Speed;
    }

    public override double CalcTime(string start,string end)
    {
        return DistInfo.GetDistance(start, end) / Speed;
    }
}

public class Track : Transporter
{
    public override double CostPerDist { get; set; }
    public override double Speed { get; set; }

    public override double CalcCost(int dist)
    {
        return dist * CostPerDist;
    }

    public override double CalcCost(string start,string end)
    {
        return ((double)DistInfo.GetDistance(start,end)) * CostPerDist;
    }

    public override double CalcTime(int dist)
    {
        return dist/Speed;
    }

    public override double CalcTime(string start,string end)
    {
        return DistInfo.GetDistance(start, end) / Speed;
    }
}
