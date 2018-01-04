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
     * @param courseId
     * @return Course object
     */
    public BasicCourse getCourse(String courseId) {
        return courses.get(courseId);
    }

    /**
     * Get a map of courses in a department
     * @param dept departmentID (e.g. 'CMSC')
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

    /**
     * Get a map of courses that satisfy certain gen ed requirements
     * @param genEds array of geneds want to satisfy
     * @return TreeMap of course IDs and course objects
     */
    public TreeMap<String, BasicCourse> getGenEndCourses(String[] genEds) {

        StringBuffer gen = new StringBuffer();
        for (String s : genEds) {
            gen.append(s);
            gen.append("|");
        }
        gen.deleteCharAt(gen.length() - 1);

       return getCourses("gen_ed=" + gen.toString());
    }

    /**
     * Get courses by semester
     * @param semester
     * @return
     */
    public TreeMap<String, BasicCourse> getSemesterCourses(String semester) {
        return getCourses("semester=" + semester);
    }

    /**
     * Get section info
     * @param sectionId
     * @return section object with all available information
     */
    public Section getSectionInfo(String sectionId) {
        String json = null;

        try {
            json = new JsonReader("http://api.umd.io/v0/courses/sections/" +
                    sectionId)
                    .readUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Gson().fromJson(json, Section.class);
    }

    /**
     * Method to get courses by custom parameters. Examples of possible
     * params would be "gen_ed=SCIS|DSSP", "dept_id=CMSC&semester=201801".
     * This is technically a helper method so be careful using this
     * @param params
     * @return map of courses
     */
    public TreeMap getCourses(String params) {
        StringBuffer json = new StringBuffer();
        ArrayList<BasicCourse> allCourses = new ArrayList<>();

        try {
            int i = 1;
            while (true) {
                json.append(new JsonReader("http://api.umd" +
                        ".io/v0/courses?per_page=100&page=" + i + "&" + params)
                        .readUrl());
                allCourses.addAll(new Gson().fromJson(json.toString().replace
                                ("][", ","),
                        new TypeToken<ArrayList<BasicCourse>>(){}.getType()));
                if (allCourses.size() % 100 == 0) {
                    i++;
                    continue;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        TreeMap<String, BasicCourse> genCourses = new TreeMap<>();

        for (BasicCourse c : allCourses) {
            genCourses.put(c.course_id, c);
        }

        return genCourses;
    }

}
