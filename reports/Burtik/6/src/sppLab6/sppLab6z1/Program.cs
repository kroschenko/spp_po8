
using sppLab6z1;

TourBuilder builder1 = new AirplaneTour();
TourBuilder builder2 = new TrainTour();

TourManager manager = new TourManager();
Tour tour1 = manager.MakeTour(builder1);
Tour tour2 = manager.MakeTour(builder2);

tour1.Print();
tour2.Print();

