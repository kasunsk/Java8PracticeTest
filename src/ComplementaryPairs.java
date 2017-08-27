import java.util.Arrays;

public class ComplementaryPairs {

    public static void main(String [] args) {

        int [] array = {1,2,3,4,5,2,8,1};

        ComplementaryPairs pairs = new ComplementaryPairs();
        System.out.println(pairs.calculateComplementaryPairs(array, 4));
    }

    public int calculateComplementaryPairs(int [] array, int k) {

        Arrays.sort(array);
        int pairsCount = 0;

        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++){

                if (k == array[i] + array[j]) {
                    pairsCount++;
                }

                if (array[j] > k)
                    break;
            }

            if(array[i] > k)
                break;
        }
        return pairsCount;
    }
}
