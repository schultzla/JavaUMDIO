import java.util.Map;

/**
 * Created by loganschultz on 1/3/18.
 */
public class Driver {

    public static void main(String[] args) {
        CourseSearch temp = new CourseSearch();

        String[] gens = {"SCIS"};
        Map<String, BasicCourse> map = temp.getGenEndCourses(gens);

        for (String s : map.keySet()) {
            System.out.println(s);
        }
    }
}
