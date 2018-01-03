import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by loganschultz on 1/3/18.
 */
public class JsonReader {

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public static void main(String[] args) {
        String json = null;
        try {
            json = readUrl("http://api.umd.io/v0/courses?dept_id=CMSC");
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Course> courses = new Gson().fromJson(json, new
                TypeToken<ArrayList<Course>>(){}.getType());

        for (Course c : courses) {
            System.out.println(c.name);
        }

    }

}
