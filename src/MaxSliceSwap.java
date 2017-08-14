import java.util.Arrays;

public class MaxSliceSwap {

    final int MAX_SWAP = 1;

    public static void main(String [] args){

        int [] array = {-10000};

        int ans = new MaxSliceSwap().solution(array);

        if (-10000 == ans) {
            System.out.println("Test One Pass " + ans);
        } else {
            System.out.println("Test One Fail " + ans );
        }
    }

    public int solution(int [] array) {

        long sum = 0;

        int [] tempArray = new int [array.length];
        System.arraycopy( array, 0, tempArray, 0, array.length );
        Arrays.sort(tempArray);
        int min = tempArray[0];

        for(int i = 0; i < array.length; i++)
            sum += array[i];




        return 0;
    }

    public int solution2(int [] array){

        int [] tempArray = new int [array.length];
        System.arraycopy( array, 0, tempArray, 0, array.length );
        Arrays.sort(tempArray);
        int min = tempArray[0];
        long sum = 0;

        for (int i = 0; i < array.length; i++){

            sum += array[i];

            if (array[i] == min && min < 0) {
                int temp = array[0];
                array[0] = min;
                array[i] = temp;
                sum = sum - min;
            }
        }

        if (min < 0) {
            int[] newArray = getNonMinusStartArray(Arrays.copyOfRange(array, 1, array.length));
            long newSum = 0;
            long maxSum = sum;

            for (int val : newArray) {

                if (newSum > maxSum) {
                    maxSum = newSum;
                }
                newSum += val;
            }
            return (int) maxSum;
        }
        return (int) sum;
    }

    private int[] getNonMinusStartArray(int[] array) {

        if (array[0] < 1) {
            return getNonMinusStartArray(Arrays.copyOfRange(array, 1, array.length));
        }
        return array;
    }

    public int solution1(int [] array) {

        long sum = 0;

        for (int val : array)
            sum += val;

        Arrays.sort(array);
        return calculateSwapSlice(sum, 0, array);
    }

    public int calculateSwapSlice(long sum, int swapTimes,  int [] array) {

        int min = array[0];

        if (min < 0 && swapTimes < MAX_SWAP) {
            sum -= min;
            swapTimes++;
            return calculateSwapSlice(sum, swapTimes, Arrays.copyOfRange(array, 1, array.length));
        } else {
            return (int) sum;
        }
    }
}
