import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by loganschultz on 1/3/18.
 *
 * Read json data from URL, try not to mess with
 */
public class JsonReader {

    private String urlString;

    public JsonReader(String url) {
        urlString = url;
    }

    /**
     * Read JSON data from a URL, try not to mess with
     * @return
     * @throws Exception
     */
    public String readUrl() throws Exception {
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
}
