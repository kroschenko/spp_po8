namespace sppLab5z1;

public interface IEducationalInstitution
{
    public void Teach();
    public void GetResult();
}

public class College : IEducationalInstitution
{
    public virtual void Teach()
    {
        Console.WriteLine("College students learned");
    }

    public virtual void GetResult()
    {
        Console.WriteLine("Issued a diploma of special education");
    }
}

public class University : College
{
    public override void Teach()
    {
        Console.WriteLine("University students learned");
    }

    public override void GetResult()
    {
        Console.WriteLine("Issued a diploma of higher education");
    }
}