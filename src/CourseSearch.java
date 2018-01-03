import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;

/**
 * Created by loganschultz on 1/3/18.
 *
 * Create this object to search for a course within the bounds
 */
public class CourseSearch {

    private ArrayList<Course> allCourses;

    /*
    List all courses
     */
    public CourseSearch() {
        String json = null;

        try {
            json = new JsonReader("http://api.umd" +
                    ".io/v0/courses/list").readUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }

        allCourses = new Gson().fromJson(json, new
                TypeToken<ArrayList<Course>>(){}.getType());
    }

    /*
    Get list of all courses
     */
    public ArrayList<Course> getCourses() {
        return allCourses;
    }
}
