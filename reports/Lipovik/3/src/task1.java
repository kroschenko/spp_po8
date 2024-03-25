public class task1 {
    public static void main(String[] args) {
        Set set= new Set(3);
        set.add(1);
        set.add(3);
        set.add(3);
        set.add(5);
        set.add(6);
        Set set1= new Set();
        set1.add(2);
        set1.add(4);
        set.merge(set1);
        System.out.println("set:\n"+set);
        System.out.println(set1.equals(set));
        Set set2= new Set();
        set2.add(2);
        set2.add(4);
        System.out.println(set1.equals(set2));
        set.erase(1);
        set.erase(2);
        System.out.println("set:\n"+set);
    }
}