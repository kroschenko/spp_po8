package task02;

import java.time.LocalTime;

public class Train {
    private String departureTime;
    private int id;
    private int trainNumber;
    private String departureStation;
    private String destinationStation;
    private int seatsAvailable;

    public Train(int id, int trainNumber, String departureStation, String destinationStation, String departureTime, int seatsAvailable) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
        this.departureTime = departureTime;
        this.seatsAvailable = seatsAvailable;
    }

    public int getTrainNumber() {
        return trainNumber;
    }
    public String getDestinationStation() {
        return destinationStation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public int getDepartureTimeAsTotalMinutes() {
        LocalTime time = LocalTime.parse(departureTime);
        return time.getHour() * 60 + time.getMinute();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Train Number: " + trainNumber + ", Departure Station: " + departureStation + ", Destination Station: " + destinationStation
                + ", Departure Time: " + departureTime + ", Seats Available: " + seatsAvailable;
    }
}
