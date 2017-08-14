/**
 * Created by kasun on 8/11/17.
 */
public class MinimumDistance {

    public static void main(String [] args) {

        int [] array = {8, 24, 3, 20, 1, 17};
        Solution solution = new Solution();
        System.out.println("Solution : " + solution.solution(array));
        System.out.println("Smart solution : "+ solution.smartSolution(array));
    }

    public int solution(int [] array) {

        return minDist(array, array.length, 0, array[array.length - 1]);
    }

    int minDist(int arr[], int n, int x, int y)
    {
        int i = 0;
        int min_dist = Integer.MAX_VALUE;
        int prev=0;

        for (i = 0; i < n; i++)
        {
            if (arr[i] == x || arr[i] == y)
            {
                prev = i;
                break;
            }
        }

        // Traverse after the first occurence
        for (; i < n; i++)
        {
            if (arr[i] == x || arr[i] == y)
            {
                if (arr[prev] != arr[i] && (i - prev) < min_dist)
                {
                    min_dist = i - prev;
                    prev = i;
                }
                else
                    prev = i;
            }
        }

        return min_dist;
    }
}
