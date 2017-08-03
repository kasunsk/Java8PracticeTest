import java.util.function.LongUnaryOperator;

/**
 * Created by kasun on 8/3/17.
 */
public class OperatorTest {

    public static void main(String [] args) {
        LongUnaryOperator lou = l -> l*2;
        long l = lou.compose(lou).compose(lou).applyAsLong(3);
        System.out.println(l);
    }
}
