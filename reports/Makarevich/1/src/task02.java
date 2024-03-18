public class task02 {
    public static void main(String[] args) {
        double[][] inputMatrix = readMatrix(args);

        double[][] transposedMatrix = transpose(inputMatrix);

        System.out.println("Original matrix: ");
        printMatrix(inputMatrix);

        System.out.println("\nTransposed matrix: ");
        printMatrix(transposedMatrix);
    }

    private static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[][] transposedMatrix = new double[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public static double[][] readMatrix(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide matrix elements.");
            System.exit(1);
        }
        int rows = Integer.parseInt(args[0]);
        int columns = Integer.parseInt(args[1]);

        if (args.length != 2 + rows * columns) {
            System.out.println("Incorrect number of matrix elements provided.");
            System.exit(1);
        }

        double[][] matrix = new double[rows][columns];
        int index = 2;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Double.parseDouble(args[index++]);
            }
        }

        return matrix;
    }
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}



