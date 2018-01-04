import java.util.Map;

/**
 * Created by loganschultz on 1/3/18.
 */
public class Driver {

    public static void main(String[] args) {
        CourseSearch temp = new CourseSearch();

        Section test = temp.getSectionInfo("CMSC132-0101");

        for (Meetings m : test.meetings) {
            System.out.println(m.days);
        }
    }
}
