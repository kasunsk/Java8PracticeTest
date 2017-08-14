import java.util.Arrays;

public class NumberOfDiscIntersections {

    public static void main(String [] args) {

        int [] array = {1,5,2,1,4,0};
        //int [] array = {1,1,1};
        System.out.println(new NumberOfDiscIntersections().solution(array));
    }

    public int solution(int [] array) {

        if (array.length == 0) {
            return 0;
        }
        int ans = totalIntersectionEachCircle(array) + solution(Arrays.copyOfRange(array, 1, array.length));

        if (ans > 10000000){
            return -1;
        }

        return ans;
    }

    private int totalIntersectionEachCircle(int[] array) {

        int radius = array[0];
        int totalIntersectionForCircle = 0;

        for (int i = 1; i <= array.length - 1; i++) {

            int circleRadius = i - array[i];

            if (radius >= i) {
                totalIntersectionForCircle++;
            } else if (radius >= circleRadius) {
                totalIntersectionForCircle++;
            }
        }
        return totalIntersectionForCircle;
    }
}
