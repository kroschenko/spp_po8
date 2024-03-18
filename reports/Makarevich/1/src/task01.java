import java.util.HashMap;
import java.util.Map;

public class task01 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide sequence elements.");
            System.exit(1);
        }

        int[] sequence = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            sequence[i] = Integer.parseInt(args[i]);
        }

        int[] modes = findModes(sequence);

        if (modes.length == 0) {
            System.out.println("Sequence mod(s) are missing.");
        } else {
            System.out.println("Sequence mod(s): ");
            for (int mode : modes) {
                System.out.println(mode);
            }
        }
    }
    public static int[] findModes(int[] sequence) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : sequence) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        int maxFrequency = 0;
        for (int count : frequency.values()) {
            maxFrequency = Math.max(maxFrequency, count);
        }
        if (maxFrequency == 1) {
            return new int[0];
        }
        int countModes = 0;
        for (int key : frequency.keySet()) {
            if (frequency.get(key) == maxFrequency) {
                countModes++;
            }
        }
        int[] modes = new int[countModes];
        int index = 0;
        for (int key : frequency.keySet()) {
            if (frequency.get(key) == maxFrequency) {
                modes[index++] = key;
            }
        }

        return modes;
    }
}
