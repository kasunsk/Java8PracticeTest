import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by kasun on 8/10/17.
 */
public class TestTask {

    ExecutorService service = Executors.newFixedThreadPool(2);


    public static void main(String [] args) {

        int [] array = {-1, 3, -4, 2};
        TestTask testTask = new TestTask();
        System.out.println(testTask.solution(array));
    }

    public static volatile boolean flag = true;


    public int solution(int [] array) {
        return equilibrium(array);
    }

    int equilibrium(int array[])
    {
        int sum = 0;      // initialize sum of whole array
        int leftsum = 0; // initialize leftsum

        /* Find sum of the whole array */
        for (int i = 0; i < array.length; ++i)
            sum += array[i];


        for (int i = 0; i < array.length; ++i)
        {
            sum -= array[i];

            if (leftsum == sum)
                return i;

            leftsum += array[i];
        }

        return -1;
    }

    public int solution3(int [] array) {


        List<Future<Integer>> tasks = new ArrayList<>();

        for (int i = 0; i< array.length; i++) {

            final int point = i;

            tasks.add(service.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {

                    BigInteger sumOfFirstHalf = calculateSum(0, point - 1, array);
                    BigInteger sumOfSecondHalf = calculateSum(point + 1, array.length - 1, array);

                    if (sumOfFirstHalf.equals(sumOfSecondHalf)) {
                        //Thread.interrupted();
                        return point;
                    }
                    return -2;
                }
            }));
        }

        for(Future<Integer> task: tasks) {

            try {
                if(task.get() != -2) {
                    return task.get();
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } catch (ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }

        return -1;
    }



    public int solution2(int [] array) {

        for (int i = 0; i< array.length; i++) {

            BigInteger sumOfFirstHalf = calculateSum(0, i - 1, array);
            BigInteger sumOfSecondHalf = calculateSum(i + 1, array.length - 1, array);

            if (sumOfFirstHalf.equals(sumOfSecondHalf)) {
                return i;
            }
        }

        return -1;
    }

    public int solutionOne(int [] array){

        if (array.length != 0) {

            int midPoint = array.length / 2;

            boolean direction = true;
            int directionCount = 1;

            while (midPoint >= 0 || midPoint < array.length - 1) {

                int sumOfFirstHalf = 0; //calculateSum(0, midPoint - 1, array);
                int sumOfSecondHalf = 0; // calculateSum(midPoint + 1, array.length - 1, array);


                if (sumOfFirstHalf == sumOfSecondHalf) {
                    return midPoint;
                }


                if (direction && array.length > 2) {
                    direction = false;
                    midPoint = midPoint + directionCount;

                    if (midPoint > array.length + 1) {
                        return -1;
                    }

                } else {
                    direction = true;
                    midPoint = midPoint - directionCount;

                    if (midPoint < -1) {
                        return -1;
                    }
                }

                directionCount++;
            }
        }

        return -1;
    }

    public BigInteger calculateSum(int startIndex, int endIndex, int [] array) {

        BigInteger sum = BigInteger.ZERO;

        if (startIndex > endIndex)
            return BigInteger.ZERO;

        for (int i = startIndex; i <= endIndex; i++) {
            sum = sum.add(new BigInteger(String.valueOf(array[i])));
        }
        return sum;
    }

    public int getArrayIndex(int[] arr,int value) {

        int k=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==value){
                k=i;
                break;
            }
        }
        return k;
    }
}
