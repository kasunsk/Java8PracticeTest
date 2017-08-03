import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kasun on 8/3/17.
 */
public class StreamTest {

    public static void main(String [] args) {
        Stream<String> stream = Stream.of("Cat", "Dog", "Rat");
        Stream<Integer> list = stream.flatMap(s -> Stream.of(s.length()));
        System.out.println(list.collect(Collectors.toSet()));
    }
}
