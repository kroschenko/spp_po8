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
        int sum = 0;
        for(int el:arr){
            sum+= el;
        }
        if(arr.length == 0){
            System.out.println("Division by 0");
            return;
        }
        int avg = sum/arr.length;

        int counter = 0;
        for(int el:arr){
            if(el>avg){
                counter++;
            }
        }
        System.out.printf("Процент чисел больше среднего: %.2f%% ", (double)counter*100/arr.length );
    }
}