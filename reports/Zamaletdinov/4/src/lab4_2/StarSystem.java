import java.util.ArrayList;
import java.util.List;

public class StarSystem {
    private Star star;
    private List<Planet> planets;

    public StarSystem(Star star) {
        this.star = star;
        this.planets = new ArrayList<>();
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    public void displayStarInfo() {
        System.out.println("Star information:");
        star.displayInfo();
    }

    public void displayPlanetsInfo() {
        System.out.println("Planets information:");
        for (Planet planet : planets) {
            planet.displayInfo();
        }
    }
}