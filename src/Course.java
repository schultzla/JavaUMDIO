import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by loganschultz on 1/3/18.
 *
 * Basic Course object, only contains the ID, name, and department
 */
public class Course {

    private String course_id, name, department;

    /**
     * Get full information about the course
     * @return New course with all potential information
     */
    public AdvancedCourse getMore() {
        String json = null;

        try {
            json = new JsonReader("http://api.umd" +
                    ".io/v0/courses?course_id=" + course_id)
                    .readUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        I have no idea why I have to use an ArrayList here instead of just
        returning a Gson object itself but it works so don't touch
         */
       ArrayList<AdvancedCourse> temp = new Gson().fromJson(json, new
                TypeToken<ArrayList<AdvancedCourse>>(){}.getType());

        return temp.get(0);
    }

    /**
     * Get the professors teaching this course
     * @return list of professors
     */
    public ArrayList<Professor> getProfessors() {
        TreeMap<String, Professor> professors = new CourseSearch().getProfessors
                ("courses=" +
                course_id);

        ArrayList<Professor> finProf = new ArrayList<>();
        for (Professor p : professors.values()) {
            finProf.add(p);
        }

        return finProf;
    }

    public String getCourseId() {
        return course_id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}
