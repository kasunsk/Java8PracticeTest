import java.util.*;

/**
 * Created by kasun on 8/8/17.
 */
public class Solution {

    public static void main(String [] args) {

        int [] array = {8, 24, 3, 24, 1, 17};
        Solution solution = new Solution();
        System.out.println("Solution : " + solution.solution(array));
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

        Arrays.sort(array);

        int min = array[1] - array[0];

        for (int i = 1 ; i < array.length - 1; i++) {

            if (min > array[i + 1] - array[i]) {
                min = array[i + 1] - array[i];
            }
        }
        return min;
    }
}
