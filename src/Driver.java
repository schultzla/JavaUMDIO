/**
 * Created by loganschultz on 1/3/18.
 */
public class Driver {

    public static void main(String[] args) {
        CourseSearch temp = new CourseSearch();

        AdvancedCourse test = temp.getCourses().get("CMSC132").getMore();

        System.out.println(test.semester);
    }
}
