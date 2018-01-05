/**
 * Created by loganschultz on 1/4/18.
 */
public class Section {

    private String section_id, course, seats, semester, open_seats, waitlist;

    private String[] instructors;

    private Meetings[] meetings;

    public String getSectionId() {
        return section_id;
    }

    public String getCourse() {
        return course;
    }

    public String getSeats() {
        return seats;
    }

    public String getSemester() {
        return semester;
    }

    public String getOpenSeats() {
        return open_seats;
    }

    public String getWaitlist() {
        return waitlist;
    }

    public String[] getInstructors() {
        return instructors;
    }

    public Meetings[] getMeetings() {
        return meetings;
    }
}
