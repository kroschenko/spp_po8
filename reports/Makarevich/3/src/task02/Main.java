package task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrainSchedule schedule = new TrainSchedule();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/task02/trains.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                int id = Integer.parseInt(parts[0]);
                int trainNumber = Integer.parseInt(parts[1]);
                String departureStation = parts[2];
                String destinationStation = parts[3];
                String departureTime = parts[4];
                int seatsAvailable = Integer.parseInt(parts[5]);
                schedule.addTrain(new Train(id, trainNumber, departureStation, destinationStation, departureTime, seatsAvailable));
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Print train schedule");
            System.out.println("2. Find train by number");
            System.out.println("3. Find trains by destination");
            System.out.println("4. Find trains by destination and time");
            System.out.println("5. Find trains by destination and seats available");
            System.out.println("6. Check trains departure in 10, 5, and 3 minutes");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    schedule.printSchedule();
                    break;
                case 2:
                    System.out.print("Enter train number: ");
                    int trainNumber = scanner.nextInt();
                    schedule.findTrainByNumber(trainNumber);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Enter destination station: ");
                    String destination = scanner.nextLine();
                    schedule.findTrainsByDestination(destination);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Enter destination station: ");
                    String dest = scanner.nextLine();
                    System.out.print("Enter time: ");
                    String time = scanner.nextLine();
                    schedule.findTrainsByDestinationAndTime(dest, time);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.print("Enter destination station: ");
                    String destStation = scanner.nextLine();
                    System.out.print("Enter minimum seats available: ");
                    int minSeats = scanner.nextInt();
                    showTrainsByDestinationAndSeats(schedule, destStation, minSeats);
                    break;
                case 6:
                    checkDepartureInMinutes(schedule);
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
        } while (choice != 7);
        scanner.close();
    }

    private static void showTrainsByDestinationAndSeats(TrainSchedule schedule, String destinationStation, int seats) {
        schedule.findTrainsByDestinationAndSeats(destinationStation, seats);
    }

    private static void checkDepartureInMinutes(TrainSchedule schedule) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter current time in minutes: ");
        int currentTimeInMinutes = scanner.nextInt();

        schedule.checkDepartureInMinutes(currentTimeInMinutes, 10);
        schedule.checkDepartureInMinutes(currentTimeInMinutes, 5);
        schedule.checkDepartureInMinutes(currentTimeInMinutes, 3);
    }
}
