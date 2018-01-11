import java.util.TreeMap;

/**
 * Created by loganschultz on 1/3/18.
 */
public class Driver {

    public static void main(String[] args) {
        CourseSearch temp = new CourseSearch();

        TreeMap<String, Professor> test = temp.getProfessors(null);

        for (String s : test.keySet()) {
            System.out.println(s);
        }


    }
}