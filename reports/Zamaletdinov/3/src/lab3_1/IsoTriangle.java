package mypack;

import java.util.Objects;

public class IsoTriangle {
    private double sideA, sideB, sideC;

    public IsoTriangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
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

    public double getSideA() {
        return sideA;
    }
    public double getSideB() {
        return sideB;
    }
    public double getSideC() {
        return sideC;
    }

    public boolean isExist(){
        return sideA + sideB > sideC && sideB + sideC > sideA && sideA + sideC > sideB;
    }

    public boolean isIsoTriangle(){
        return sideA==sideB || sideA==sideC || sideB==sideC;
    }

    public double getPerimeter(){
        return sideA + sideB + sideC;
    }

    public double getArea(){
        double semiPerim = (this.sideA + this.sideB + this.sideC)/2;
        return Math.sqrt(semiPerim * (semiPerim-sideA) * (semiPerim-sideB) * (semiPerim-sideC));
    }

    @Override
    public String toString() {
        return "sideA: " + sideA + "; sideB: " + sideB + "; sideC: " + sideC + ";";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IsoTriangle that = (IsoTriangle) o;
        return Double.compare(sideA, that.sideA) == 0 && Double.compare(sideB, that.sideB) == 0 && Double.compare(sideC, that.sideC) == 0;
    }

}
