public class IsoscelesTriangle {
    private double sideA, sideB, sideC;

    public IsoscelesTriangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }
    public double getSideB() {
        return sideB;
    }
    public double getSideC() {
        return sideC;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }
    public void setSideB(double sideB) {
        this.sideB = sideB;
    }
    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public double determinePerimeter() {
        return sideA + sideB + sideC;
    }
    public double determineArea() {
        double semiperimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - sideA) * (semiperimeter - sideB) * (semiperimeter - sideC));
    }

    // проверка, может ли сущестовать такой треугольник
    public boolean isTriangleExists() { return sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA; }

    // проверка, яаляется ли треугольник равнобедренным
    public boolean isIsoscelesTriangle() {
        return (sideA == sideB) ||
                (sideA == sideC) ||
                (sideB == sideC);
    }

    @Override
    public String toString() {
        return "{ sideA: " + sideA + ", sideB: " + sideB + ", sideC: " + sideC + " }";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        IsoscelesTriangle other = (IsoscelesTriangle) obj;
        return sideA == other.sideA && sideB == other.sideB && sideC == other.sideC;
    }
}
