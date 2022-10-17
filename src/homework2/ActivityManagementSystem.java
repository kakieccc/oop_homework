package homework2;

import java.util.List;

public class ActivityManagementSystem {

    private ActivitySubSystem activitySubSystem;
    private UserSubSystem userSubSystem;

    public ActivityManagementSystem() {

        this.activitySubSystem = new ActivitySubSystem();
        this.userSubSystem = new UserSubSystem();
    }

    public void displayUserSubSystem() {

        System.out.println("Students:\n");
        List<Student> studentList = userSubSystem.getStudentList();
        for(Student student : studentList) {
            System.out.println(student.toString());
        }
    
        System.out.println("Organizers:\n");
        List<Organizer> organizerList = userSubSystem.getOrganizerList();
        for(Organizer organizer : organizerList) {
            System.out.println(organizer.toString());
        }
    
        System.out.println("Teachers:\n");
        List<Teacher> teacherList = userSubSystem.getTeacherList();
        for(Teacher teacher : teacherList) {
            System.out.println(teacher.toString());
        }
    }

    public void displayActivitySubSystem() {

        System.out.println("Activities:\n");
        List<Activity> activityList = activitySubSystem.getActivityList();
        for(Activity activity : activityList) {
            System.out.println(activity.toString());
        }
    }

    public UserSubSystem getUserSubSystem() {

        return userSubSystem;
    }
    public ActivitySubSystem getActivitySubSystem() {

        return activitySubSystem;
    }
}
