import java.util.TreeMap;

/**
 * Created by loganschultz on 1/11/18.
 */
public class Professor {

    private String name;

    private String[] departments;

    private String[] courses;

    public String getName() {
        return name;
    }

    public String[] getDepartments() {
        return departments;
    }

    /**
     * Gets the professors courses
     * @return map of courses
     */
    public TreeMap<String, Course> getCourses() {
        TreeMap<String, Course> temp = new TreeMap<>();

        for (String s : courses) {
            temp.put(s, new CourseSearch().getCourse(s));
        }

        return temp;
    }
}
