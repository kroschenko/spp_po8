package task01;

public class Main {
    public static void main(String[] args) {
        Task01 set1 = new Task01(5);
        set1.add('a');
        set1.add('b');
        set1.add('c');
        System.out.println("Set 1: " + set1);

        Task01 set2 = new Task01(5);
        set2.add('b');
        set2.add('c');
        set2.add('d');
        System.out.println("Set 2: " + set2);

        set1.remove('b');
        System.out.println("Set 1 after removing 'b': " + set1);

        set2.remove('c');
        System.out.println("Set 2 after removing 'с': " + set2);

        System.out.println("Is 'c' in Set 1? " + set1.contains('c'));
        System.out.println("Is 'd' in Set 1? " + set1.contains('d'));

        System.out.println("Are Set 1 and Set 2 equal? " + set1.equals(set2));

    }
}
