/**
 * Created by kasun on 8/3/17.
 */
public class ExceptionTest {

    Integer l;

    public static void main(String [] args){

        String s;

        try {
            s = new ExceptionTest().l.toString();
        } finally {

            try {
                int i = Integer.parseInt("A");
            } catch (NumberFormatException E) {
                System.out.println("NumberFormat");
            } finally {
                System.out.println("Fin2");
            }
            System.out.println("Fin1");
        }
    }
}
