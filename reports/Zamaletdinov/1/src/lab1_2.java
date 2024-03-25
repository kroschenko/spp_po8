public class Main {
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                arr[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка преобразования в число: " + args[i]);
                return;
            }
        }
        int size = arr[0];

        double[][] array = makeIdentityMatrix(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static double[][] makeIdentityMatrix(int size){
        double[][] array = new double[size][size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            array[i][j] = 1;
            j++;
        }

        return array;
    }
}