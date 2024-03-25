
public interface IMobile
{
    void Call();
    void Message();
    void PhotoShoot();

}

public abstract class SamsungMobile : IMobile
{
    public abstract void Call();
    public abstract void Message();
    public abstract void PhotoShoot();


    public void GPSNavigation()
    {
        Console.WriteLine("Enable GPS Navigation");
    }
   
}

public class Model : SamsungMobile
{
    public override void Call()
    {
        Console.WriteLine("Calling contact ...");
    }

    public override void Message()
    {
        Console.WriteLine("Staring chat with...");
    }
    public override void PhotoShoot()
    {
        Console.WriteLine("Turning on Camera...");
    }

}

class Program
{
    static void Main(string[] args)
    {
        Model model = new Model();
        model.Call();
        model.Message();
        model.GPSNavigation();
        model.PhotoShoot();
    }
}
