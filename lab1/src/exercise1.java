package lab1;

public class exercise1 {
    public static void main(String[] args) {
        int[] sequence = new int[args.length];
        for(int i=0;i< args.length;i++){
            try{
                sequence[i]=Integer.parseInt(args[i]);
            }
            catch (NumberFormatException e) {
                System.out.println("Неправильные значения");
                return;
            }
        }
        for(int i=1;i<args.length;i++){
            if(!(sequence[0]==sequence[i])){
                System.out.println("Элементы массива не равны.");
                return;
            }
        }
        System.out.println("Элементы массива равны.");
    }
}
