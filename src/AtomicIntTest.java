import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kasun on 8/3/17.
 */
public class AtomicIntTest {

    int val = 10;

    int x;

    AtomicIntTest(int i) {
        val = i;
    }

    private AtomicInteger value = new AtomicInteger(val);

    public static void main(String [] args) {

        AtomicIntTest atomicIntTest = new AtomicIntTest(5);

        System.out.println(atomicIntTest.value.getAndDecrement());
    }
}
