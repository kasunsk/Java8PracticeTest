import java.util.Arrays;

/**
 * Created by kasun on 8/8/17.
 */
public class EvenFinder {

    public static void main(String [] args) {

        int [] array = {2,1,5, -6, 9};

        EvenFinder evenFinder = new EvenFinder();
        System.out.println(evenFinder.findAddEvenFairs(array));

    }

    public int findAddEvenFairs(int [] array) {

        int evenCount = 0;
        int oddCount = 0;

        for (int val : array) {

            if ((val & 1) == 0) {
                evenCount++;
            } else
                oddCount++;
        }

        int pairs =  find(evenCount) + find(oddCount);

        if (pairs > 1000000000) {
            return -1;
        } else {
            return pairs;
        }
    }

    public int find(int n) {

        if (n == 0 || n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        } else {
            return n - 1 + find(n - 1);
        }
    }
}
