/**
 * Created by loganschultz on 1/3/18.
 */
public class Driver {

    public static void main(String[] args) {
        CourseSearch temp = new CourseSearch();

        for (String s : temp.getDepartmentCourses("CMSC").keySet()) {
            System.out.println(s);
        }

    }
}
