import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;

/**
 * Created by loganschultz on 1/3/18.
 *
 * Basic Course object, only contains the ID, name, and department
 */
public class BasicCourse {

    String course_id, name, department;

    /*
    Get all possible information about the course, returns an Advanced Course
    object
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

       ArrayList<AdvancedCourse> temp = new Gson().fromJson(json, new
                TypeToken<ArrayList<AdvancedCourse>>(){}.getType());

        return temp.get(0);
    }

}
