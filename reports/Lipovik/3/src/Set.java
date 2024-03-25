import java.util.Arrays;

public class Set {
    private int size;
    private int[] elements;

    Set(int capacity){
        size=0;
        elements=new int[capacity];
    }
    Set(int[] set){
        elements=set;
        size=set.length-1;
    }
    Set(){
        size=0;
        elements=new int[5];
    }
    public void merge(Set set){
        int[] newElements = new int[elements.length+set.elements.length];
        size+=set.size;
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        System.arraycopy(set.elements, 0, newElements, elements.length, set.elements.length);
        elements=new int[newElements.length];
        elements=Arrays.stream(Arrays.stream(newElements).sorted().toArray()).distinct().toArray();
    }
    @Override
    public String toString(){
        StringBuilder str= new StringBuilder();
        for(int i=elements.length-size;i< elements.length;i++){
            str.append(elements[i]).append("\n");
        }
        return str.toString();
    }
    public int contains(int value){
        for(int i=elements.length-size;i< elements.length;i++){
            if(elements[i]==value){
                return i;
            }
        }
        return -1;
    }
    public void add(int value){
        if(elements.length==size){
            System.out.println("the set is completely filled!");
        }
        else{
            if(contains(value)==-1){
                elements[0]=value;
                elements=Arrays.stream(elements).sorted().toArray();
                size++;
            }
        }
    }
    public void erase(int value){
        int index=contains(value);
        if(index!=-1){
            elements[index]=0;
            size--;
            elements=Arrays.stream(elements).sorted().toArray();
        }
        else{
            System.out.println("the set does not contain this element!");
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            System.out.println("not same class!");
            return false;
        }

        Set set = (Set) obj;
        return size==set.size && Arrays.equals(elements, set.elements);
    }
}
