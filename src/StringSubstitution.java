import java.util.HashMap;
import java.util.Map;

/**
 * Created by kasun on 8/9/17.
 */
public class StringSubstitution {

    static Map<String,String> rules = new HashMap<>();

    static {
        rules.put("AB", "AA");
        rules.put("BA", "AA");
        rules.put("CB", "CC");
        rules.put("BC", "CC");
        rules.put("AA","A");
        rules.put("CC", "C");
    }

    public static void main(String [] args) {

        String s = "ABBCC";

        StringSubstitution substitution = new StringSubstitution();
        System.out.println(substitution.solution(s));

    }

    private String solution(String s) {

        StringBuilder buffer = new StringBuilder(s);

        StringBuilder tempBuff = new StringBuilder("");

        while (!tempBuff.toString().equals(buffer.toString())) {

            tempBuff.setLength(0);
            tempBuff.append(buffer);

            for (String val : rules.keySet()) {

                if (buffer.toString().contains(val)) {

                    int index = buffer.indexOf(val);
                    buffer.replace(index, index + 2, rules.get(val));
                }
            }
        }

        return buffer.toString();
    }
}
