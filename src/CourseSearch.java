import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by loganschultz on 1/3/18.
 *
 * Creates a map of all the courses available the current semester at UMD
 */
public class CourseSearch {

    private TreeMap<String, BasicCourse> courses;

    public CourseSearch() {

        String json = null;

        try {
            json = new JsonReader("http://api.umd.io/v0/courses/list")
                    .readUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<BasicCourse> allCourses = new Gson().fromJson(json, new
                TypeToken<ArrayList<BasicCourse>>(){}.getType());

        courses = new TreeMap<>();

        for (BasicCourse c : allCourses) {
            courses.put(c.course_id, c);
        }
    }

    public TreeMap<String, BasicCourse> getCourses() {
        return courses;
    }
}
