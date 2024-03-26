package lab3.exercise1;

public class Main {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(5, 5, 6);
        Triangle triangle2 = new Triangle(3, 4, 5);

        System.out.println("Triangle 1:");
        System.out.println("Perimeter: " + triangle1.calculatePerimeter());
        System.out.println("Area: " + triangle1.calculateArea());
        System.out.println("Exists: " + triangle1.exists());

        System.out.println("\nTriangle 2:");
        System.out.println("Perimeter: " + triangle2.calculatePerimeter());
        System.out.println("Area: " + triangle2.calculateArea());
        System.out.println("Exists: " + triangle2.exists());

        System.out.println("\nTesting equals method:");
        System.out.println("Are triangles equal? " + triangle1.equals(triangle2));
    }
}

