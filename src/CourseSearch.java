import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by loganschultz on 1/3/18.
 *
 * Main wrapper object. Initiate CourseSearch with no params to get methods
 */
public class CourseSearch {

    private TreeMap<String, BasicCourse> courses;

    /**
     * Initiate's courses map with every possible course, with only basic
     * information
     */
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

    /**
     * Get a specific course (Use .getMore() on Course to get all information)
     * @param Course ID
     * @return Course object
     */
    public BasicCourse getCourse(String courseId) {
        return courses.get(courseId);
    }

    /**
     * Get a map of courses in a department
     * @param Department ID (e.g. 'CMSC')
     * @return TreeMap of course IDs and Course objects
     */
    public TreeMap<String, BasicCourse> getDepartmentCourses(String dept) {
        TreeMap<String, BasicCourse> map = new TreeMap<>();

        for (BasicCourse c : courses.values()) {
            if (c.course_id.contains(dept)) {
                map.put(c.course_id, c);
            }
        }

        return map;
    }


}
