package task02;

import java.util.ArrayList;
import java.util.List;

public class TrainSchedule {
    private List<Train> trains;

    public TrainSchedule() {
        this.trains = new ArrayList<>();
    }

    public void addTrain(Train train) {
        this.trains.add(train);
    }

    public void printSchedule() {
        if (trains.isEmpty()) {
            System.out.println("Train schedule is empty.");
        } else {
            System.out.println("Train Schedule:");
            for (Train train : trains) {
                System.out.println(train);
            }
        }
    }

    public void findTrainByNumber(int trainNumber) {
        boolean found = false;
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                System.out.println("Train found: " + train);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Train with number " + trainNumber + " not found.");
        }
    }

    public void findTrainsByDestination(String destinationStation) {
        List<Train> matchingTrains = new ArrayList<>();
        for (Train train : trains) {
            if (train.getDestinationStation().equalsIgnoreCase(destinationStation)) {
                matchingTrains.add(train);
            }
        }
        if (matchingTrains.isEmpty()) {
            System.out.println("No trains found for destination: " + destinationStation);
        } else {
            System.out.println("Trains to " + destinationStation + ":");
            for (Train train : matchingTrains) {
                System.out.println(train);
            }
        }
    }

    public void findTrainsByDestinationAndTime(String destinationStation, String time) {
        List<Train> matchingTrains = new ArrayList<>();
        for (Train train : trains) {
            if (train.getDestinationStation().equalsIgnoreCase(destinationStation) &&
                    train.getDepartureTime().compareTo(time) > 0) {
                matchingTrains.add(train);
            }
        }
        if (matchingTrains.isEmpty()) {
            System.out.println("No trains found for destination " + destinationStation + " after " + time);
        } else {
            System.out.println("Trains to " + destinationStation + " after " + time + ":");
            for (Train train : matchingTrains) {
                System.out.println(train);
            }
        }
    }

    public void findTrainsByDestinationAndSeats(String destinationStation, int seats) {
        List<Train> matchingTrains = new ArrayList<>();
        for (Train train : trains) {
            if (train.getDestinationStation().equalsIgnoreCase(destinationStation) &&
                    train.getSeatsAvailable() >= seats) {
                matchingTrains.add(train);
            }
        }
        if (matchingTrains.isEmpty()) {
            System.out.println("No trains found for destination " + destinationStation + " with at least " + seats + " seats available.");
        } else {
            System.out.println("Trains to " + destinationStation + " with at least " + seats + " seats available:");
            for (Train train : matchingTrains) {
                System.out.println(train);
            }
        }
    }

    public void checkDepartureInMinutes(int currentTotalMinutes, int minutes) {
        for (Train train : trains) {
            int departureTotalMinutes = train.getDepartureTimeAsTotalMinutes();
            if (departureTotalMinutes - currentTotalMinutes == minutes) {
                System.out.println("Train number " + train.getTrainNumber() + " is departing in " + minutes + " minutes.");
            }
        }
    }
}

