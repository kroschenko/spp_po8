import java.util.Scanner;

public class lab1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы: ");
        int size = scanner.nextInt();
        scanner.close();
        
        double[][] Matrix = single(size);
        System.out.println("Единичная матрица:");
        printMatrix(Matrix);
    }

    public static double[][] single(int size) {
        double[][] Matrix = new double[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    Matrix[i][j] = 1.0;
                } else {
                    Matrix[i][j] = 0.0;
                }
            }
        }
        
        return Matrix;
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}