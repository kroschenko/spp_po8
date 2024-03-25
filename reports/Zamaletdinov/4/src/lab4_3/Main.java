public class Main {
    public static void main(String[] args) {
        Pilot pilot = new Pilot("Фролов Михаил Дмитриевич");
        Navigator navigator = new Navigator("Дроздов Тимофей Андреевич");
        RadioOperator radioOperator = new RadioOperator("Беляев Александр Фёдорович");
        FlightAttendant flightAttendant1 = new FlightAttendant("Попова Яна Юрьевна");
        FlightAttendant flightAttendant2 = new FlightAttendant("Шилова Полина Львовна");

        Aircraft aircraft = new Aircraft("Boeing-737",150, 5000);

        Flight flight = new Flight(aircraft, "Аэропорт Минск", "Аэропорт Шереметьево");

        flight.addCrewMember(pilot);
        flight.addCrewMember(navigator);
        flight.addCrewMember(radioOperator);
        flight.addCrewMember(flightAttendant1);
        flight.addCrewMember(flightAttendant2);

        flight.displayFlightInfo();

        flight.cancelFlight();

        flight.changeDestination("Аэропорт Калуга");

        flight.displayFlightInfo();
    }
}