class Planet {
    private String name;
    private double distanceFromStar;

    public Planet(String name, double distanceFromStar) {
        this.name = name;
        this.distanceFromStar = distanceFromStar;
    }

    public void displayInfo() {
        System.out.println("Planet name: " + name);
        System.out.println("Distance from star: " + distanceFromStar + " AU");
    }
}