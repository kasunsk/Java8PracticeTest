import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kasun on 8/22/17.
 */
public class ComplementaryPairs {

    public static void main(String [] args) {

        int [] array = {1,2,3,4,5,2,8,1};

        ComplementaryPairs pairs = new ComplementaryPairs();
        System.out.println(pairs.noOfComplementaryPairs(array, 4));
    }


    public int calculateComplementaryPairs(int [] array, int k) {

        int pairsCount = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++){

                if (k == array[i] + array[j]) {
                    pairsCount++;
                }
            }
        }
        return pairsCount;
    }

    public int noOfComplementaryPairs(int arr[], int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.merge(k - arr[i], 1, Integer::sum);
        }
        return Arrays.stream(arr).map(element -> map.getOrDefault(element, 0)).sum();
    }

    public int test(int arr[], int sum) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(sum - arr[i], 1);
        }
        return 0;
    }
}
