import java.math.BigInteger;
import java.util.*;

/**
 * Created by kasun on 8/8/17.
 */
public class Solution {

    public static void main(String [] args) {

        int [] array = {7, 21, 3, 42, 3, 7};
        Solution solution = new Solution();
        System.out.println("Smart solution : "+ solution.smartSolution(array));

    }

    public int solution(int [] array) {

        int min;

        if (array[0] - array[1] >= 0) {
            min = array[0] - array[1];
        } else {
            min = array[1] - array[0];
        }

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j<array.length; j++) {

                if ( i != j) {

                    if ( array[i] - array[j] < min && array[i] - array[j] >= 0) {
                        min = array[i] - array[j];
                    }
                }
            }
        }
        return min;
    }

    public int smartSolution(int [] array) {

        if (array.length < 2)
            return -1;

        Arrays.sort(array);

        BigInteger min = new BigInteger(String.valueOf(array[1] - array[0]));

        for (int i = 1 ; i < array.length - 1; i++) {

            BigInteger dist = new BigInteger(String.valueOf(array[i + 1] - array[i]));

            if (min.compareTo(dist) == 1) {
                min = dist;
            }
        }
        return min.intValue();
    }
}
