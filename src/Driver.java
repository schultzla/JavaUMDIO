import java.util.TreeMap;

/**
 * Created by loganschultz on 1/3/18.
 */
public class Driver {

    public static void main(String[] args) {
        CourseSearch temp = new CourseSearch();

        TreeMap<String, Course> map = temp.getCourseByProfessorLastName("Emad");

        for (String s : map.keySet()) {
            System.out.println(map.get(s).getName());
        }

    }
}