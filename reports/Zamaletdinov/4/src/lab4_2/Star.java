class Star {
    private String name;
    private String type;

    public Star(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void displayInfo() {
        System.out.println("Star name: " + name);
        System.out.println("Star type: " + type);
    }
}