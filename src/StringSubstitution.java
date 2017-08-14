import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kasun on 8/9/17.
 */
public class StringSubstitution {

    static Map<String,String> rulesMap = new HashMap<>();

    String[] rules = { "AB", "BA", "CB", "BC", "AA", "CC" };

    static {
        rulesMap.put("AB", "AA");
        rulesMap.put("BA", "AA");
        rulesMap.put("CB", "CC");
        rulesMap.put("BC", "CC");
        rulesMap.put("AA","A");
        rulesMap.put("CC", "C");
    }

    public static void main(String [] args) {

        String s = "ABBCC";

        StringSubstitution substitution = new StringSubstitution();
        System.out.println(substitution.solution(s));

    }

 //   private String solution1(String s) {

//        StringBuilder buffer = new StringBuilder(s);
//
//        StringBuilder tempBuff = new StringBuilder("");
//
//        while (!tempBuff.toString().equals(buffer.toString())) {
//
//            tempBuff.setLength(0);
//            tempBuff.append(buffer);
//
//            for (String val : rules.keySet()) {
//
//                if (buffer.toString().contains(val)) {
//
//                    int index = buffer.indexOf(val);
//                    buffer.replace(index, index + 2, rules.get(val));
//                }
//            }
//        }
//
//        return buffer.toString();
 //   }

    private String solution(String text){

        ArrayList<String> possibleRules = new ArrayList<String>();

        for (String rule : rules) {
            if (text.contains(rule)) {
                possibleRules.add(rule);
            }
        }

        if (possibleRules.size() == 0) {
            return text;
        } else {

            String REGEX = possibleRules.get(0);
            String REPLACE = rulesMap.get(REGEX);

            Pattern p = Pattern.compile(REGEX);
            Matcher m = p.matcher(text);
            text = m.replaceFirst(REPLACE);

            return solution(text);

        }
    }


}
