package lab3.exercise1;

public class Triangle {
    private double sideA;
    private double sideB;
    private double base;

    public Triangle(double sideA, double sideB, double base) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.base = base;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double calculatePerimeter() {
        return sideA + sideB + base;
    }

    public double calculateArea() {
        double height = Math.sqrt(sideA * sideA - (base * base / 4));
        return 0.5 * base * height;
    }

    public boolean exists() {
        return (sideA + sideB > base && sideA + base > sideB && sideB + base > sideA);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", base=" + base +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle that = (Triangle) o;
        return Double.compare(that.sideA, sideA) == 0 &&
                Double.compare(that.sideB, sideB) == 0 &&
                Double.compare(that.base, base) == 0;
    }
}
