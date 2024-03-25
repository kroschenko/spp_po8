namespace sppLab6z1;

public abstract class TourBuilder
{
    public Tour Tour { get; set; }

    public void CreateTour()
    {
        Tour = new Tour();
    }

    public abstract void AddTravel();
    public abstract void AddAccommodation();
    public abstract void AddNutrition();
    public abstract void AddPlace();
}

public class Tour()
{
    
    public string Travel { get; set; }
    public string Accommodation { get; set; }
    public string Nutrition { get; set; }
    public List<string> Place { get; set; }

    public void Print()
    {
        Console.WriteLine($"Travel: {Travel}");
        Console.WriteLine($"Accommodation: {Accommodation}");
        Console.WriteLine($"Nutrition: {Nutrition}");
        string str = "";
        foreach (var s in Place)
        {
            str+=$"{s} ";
        }
        Console.WriteLine($"Place: {str}");
    }
}

public class TourManager()
{
    public Tour MakeTour(TourBuilder tourBuilder)
    {
        tourBuilder.CreateTour();
        tourBuilder.AddTravel();
        tourBuilder.AddAccommodation();
        tourBuilder.AddNutrition();
        tourBuilder.AddPlace();
        return tourBuilder.Tour;
    }
}

public class AirplaneTour : TourBuilder 
{
    public override void AddTravel()
    {
        Tour.Travel = "Airplane";
    }

    public override void AddAccommodation()
    {
        Tour.Accommodation = "Hotel 5*";
    }

    public override void AddNutrition()
    {
        Tour.Nutrition = "Full";
    }

    public override void AddPlace()
    {
        Tour.Place = new List<string>();
        Tour.Place.Add("All");
    }
}

public class TrainTour : TourBuilder
{
    public override void AddTravel()
    {
        Tour.Travel = "Train";
    }

    public override void AddAccommodation()
    {
        Tour.Accommodation = "Hotel 3*";
    }

    public override void AddNutrition()
    {
        Tour.Nutrition = "Only breakfast";
    }

    public override void AddPlace()
    {
        Tour.Place = new List<string>();
        Tour.Place.Add("Theatre");
    }
}