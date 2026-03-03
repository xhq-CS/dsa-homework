import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;

    //constructor
    public CourseManager() {courses = new ArrayList<>();}

    //adds course
    public void addCourse(Course course) {
        if (course == null) {return;}
        String courseCode = course.getCourseCode();
        if (courseCode == null || courseCode.isEmpty()) {return;}
        if (findCourse(courseCode) != null) {return;}
        courses.add(course);
    }

    //finds course
    public Course findCourse(String courseCode) {
        if (courseCode == null || courseCode.isEmpty()) {return null;}
        if (courses == null || courses.isEmpty()) {return null;}
        for (Course course : courses) {
            if (course == null) {continue;}
            if (courseCode.equals(course.getCourseCode())) {
                return course;
            }
        }
        return null;
    }

    //returns instructor's courses
    public ArrayList<Course> getCoursesByInstructor(String instructor) {
        ArrayList<Course> courseList = new ArrayList<>();
        if (instructor == null || instructor.isEmpty()) {return courseList;}
        if (courses == null || courses.isEmpty()) {return courseList;}
        for (Course course : courses) {
            if (course == null) {continue;}
            if (instructor.equals(course.getInstructor())) {
                courseList.add(course);
            }
        }
        return courseList;
    }

    //returns courses student can take (not already enrolled, prerequisites met)
    public ArrayList<Course> getAvailableCourses(String studentId, StudentManager studentManager, EnrollmentManager enrollmentManager) {
        ArrayList<Course> availCourse = new ArrayList<>();
        if (studentId == null || studentId.isEmpty()) {return availCourse;}
        if (studentManager == null || enrollmentManager == null) {return availCourse;}
        if (studentManager.findStudent(studentId) == null) {return availCourse;}
        if (courses == null || courses.isEmpty()) {return availCourse;}
        ArrayList<Enrollment> enrolledList = enrollmentManager.getEnrollmentsByStudent(studentId);

        for (Course course : courses) {
            if (course == null) {continue;}
            String courseCode = course.getCourseCode();
            if (courseCode == null || courseCode.isEmpty()) {continue;}
            //enrollment check
            boolean enrolled = false;
            for (Enrollment e : enrolledList) {
                if (e == null) continue;
                if (courseCode.equals(e.getCourseCode())) {
                    enrolled = true;
                    break;
                }
            }
            if (enrolled) {continue;}
            //prereq check
            boolean hasPrerequisites = true;
            ArrayList<String> prerequisites = course.getPrerequisites();
            for (String p : prerequisites) {
                if (p == null || p.isEmpty()) {
                    continue;
                }
                boolean prereqMet = false;
                for (Enrollment e : enrolledList) {
                    if (e == null) {
                        continue;
                    }
                    if (p.equals(e.getCourseCode()) && e.isPassing()) {
                        prereqMet = true;
                        break;
                    }
                }
                if (!prereqMet) {
                    hasPrerequisites = false;
                    break;
                }
            }
            if (hasPrerequisites) {availCourse.add(course);}
        }
        return availCourse;
    }

    //returns number of courses
    public int getTotalCourses() {return courses.size();}

    //prints all courses
    public void printAllCourses() {
        if (courses == null || courses.isEmpty()) {
            System.out.println("No courses.");
            return;
        }
        System.out.println("All Courses:");
        for (Course c : courses) {
            if (c == null) continue;
            System.out.println(c);
        }
    }
}
