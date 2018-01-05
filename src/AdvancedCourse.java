/**
 * Created by loganschultz on 1/3/18.
 *
 * All possible information about a course
 */
public class AdvancedCourse {

    private String course_id, name, dept_id, department, semester, credits,
            description;

    private String[] grading_method, core, gen_ed, sections;

    public Section[] getSections() {
        Section[] ans = new Section[sections.length];

        int i = 0;
        for (String s : sections) {
            ans[i] = new CourseSearch().getSectionInfo(s);
            i++;
        }

        return ans;
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

    public String getDeptId() {
        return dept_id;
    }

    public String getSemester() {
        return semester;
    }

    public String getCredits() {
        return credits;
    }

    public String getDescription() {
        return description;
    }

    public String[] getGradingMethod() {
        return grading_method;
    }

    public String[] getCore() {
        return core;
    }

    public String[] getGenEds() {
        return gen_ed;
    }
}
