import java.util.*;

public class Flags {

    public static void main(String [] args) {

        int [] array = new int[] {1, 5 , 3 , 4, 1};
        System.out.println(new Flags().solution(array, array.length));

    }

    public int solution(int [] array, int length) {

        Map<Integer, Integer> peaks = findPeaks(array);

        int initialFlags = peaks.values().size();
        int maxFlags = initialFlags;

        List<Integer> flags = new ArrayList<>();

        int flagCount = 0;

        boolean isFirstPoint = true;

        for (int i = peaks.size(); i > 0; i--) {

            for (Map.Entry<Integer, Integer> entry : peaks.entrySet()) {

                int prevPoint = 0;

                if (!isFirstPoint) {
                    prevPoint = entry.getKey();
                }

                isFirstPoint = false;

                int distance = entry.getKey() - prevPoint;

                if (distance <= maxFlags) {
                    flagCount++;
                }
            }
        }

        flags.add(flagCount);

        Collections.sort(flags);

        return flags.get(flags.size() - 1);
    }

    public Map<Integer, Integer> findPeaks(int [] array) {

        Map<Integer, Integer> peaks = new HashMap<>();

        for (int i = 1; i < array.length - 1; i++) {

            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                peaks.put(i, array[i]);
            }
        }

        return peaks;

    }
}
