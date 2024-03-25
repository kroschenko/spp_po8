class Aircraft {

    private String name;
    private int capacity;
    private double range;

    public Aircraft(String name, int capacity, double range) {
        this.name = name;
        this.capacity = capacity;
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getRange() {
        return range;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public void showAircraftInfo(){
        System.out.println(name + ":\nДальность полёта: " + capacity + "\nВместительность: " + range);
    }

}