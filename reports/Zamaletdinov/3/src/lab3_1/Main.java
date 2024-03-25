package mypack;

public class Main {
    public static void main(String[] args) {
        IsoTriangle triangle1 = new IsoTriangle(10,10,10);
        IsoTriangle triangle2 = new IsoTriangle(10,6,6);

        if (triangle1.isExist() && triangle1.isIsoTriangle()){
            System.out.println("Равнобедренный треугольник 1 со сторонами: " + triangle1.toString());
            System.out.println("Периметр: " + triangle1.getPerimeter() + "; площадь: " + triangle1.getArea() + ".\n");
        }
        else {
            System.out.println("Неверные параметры треугольника.");
        }

        if (triangle2.isExist() && triangle2.isIsoTriangle()){
            System.out.println("Равнобедренный треугольник 2 со сторонами: " + triangle2.toString());
            System.out.println("Периметр: " + triangle2.getPerimeter() + "; площадь: " + triangle2.getArea() + ".\n");
        }
        else {
            System.out.println("Неверные параметры треугольника.");
        }

        if (triangle1.isExist() && triangle1.isIsoTriangle() && triangle2.isExist() && triangle2.isIsoTriangle()){
            if (triangle1.equals(triangle2)){
                System.out.println("Треугольники равны.");
            }
            else {
                System.out.println("Треугольники не равны.");
            }
        }
    }
}