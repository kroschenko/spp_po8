package task01;

import java.util.Arrays;

public class Task01 {
    private char[] symbols;
    private int size;

    public Task01(int capacity) {
        symbols = new char[capacity];
        size = 0;
    }

    public void add(char element) {
        if (size >= symbols.length) {
            System.out.println("Array is full. Cannot add more elements.");
            return;
        }

        if (contains(element)) {
            System.out.println("Element " + element + " already exists in the array.");
            return;
        }

        symbols[size++] = element;
        System.out.println("Added element " + element);
    }

    public void remove(char element) {
        for (int i = 0; i < size; i++) {
            if (symbols[i] == element) {
                symbols[i] = symbols[size - 1];
                symbols[size - 1] = 0;
                size--;
                System.out.println("Removed element " + element);
                return;
            }
        }
        System.out.println("Element " + element + " not found in the array.");
    }

    public boolean contains(char element) {
        for (int i = 0; i < size; i++) {
            if (symbols[i] == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(symbols, size));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Task01)) {
            return false;
        }
        Task01 other = (Task01) obj;
        return Arrays.equals(Arrays.copyOf(symbols, size), Arrays.copyOf(other.symbols, other.size));
    }
}
