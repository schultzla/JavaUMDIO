/**
 * Created by loganschultz on 1/3/18.
 */
public class Driver {

    public static void main(String[] args) {
        CourseSearch course = new CourseSearch();

        for (Professor p : course.getCourse("CMSC132").getProfessors()) {
            System.out.println(p.getName());
        }
    }
}