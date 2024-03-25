import java.util.ArrayList;
import java.util.List;

class Flight {
    private List<CrewMember> crew;
    private Aircraft aircraft;
    private String departureAirport;
    private String destinationAirport;
    private boolean canceled;

    public Flight(Aircraft aircraft, String departureAirport, String destinationAirport) {
        this.aircraft = aircraft;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.crew = new ArrayList<>();
        this.canceled = false;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public List<CrewMember> getCrew() {
        return crew;
    }

    public void addCrewMember(CrewMember crewMember) {
        crew.add(crewMember);
    }

    public void cancelFlight() {
        this.canceled = true;
        System.out.println("\nРейс отменён!");
    }

    public void changeDestination(String newDestinationAirport) {
        this.destinationAirport = newDestinationAirport;
    }

    public void changeDeparture(String newDepartureAirport) {
        this.departureAirport = newDepartureAirport;
    }

    public void displayFlightInfo() {
        System.out.println("Экипаж:");
        for (CrewMember member : crew) {
            System.out.println(member.getClass().getName() + ": " + member.getName());
        }

        System.out.println("");
        aircraft.showAircraftInfo();

        System.out.println("\n" + departureAirport + " -> " + destinationAirport);
    }
}