package homework2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {

    private String teamId;
    private String teamName;
    private String department;
    private Student creator;

    private List<Student> studentList;
    private List<Teacher> teacherList;

    public Team(String initialTeamId, String initialTeamName, String initialDepartment, Student initialCreator) {
        this.teamId = initialTeamId;
        this.teamName = initialTeamName;
        this.department = initialDepartment;
        this.creator = initialCreator;
        this.studentList = new ArrayList<Student>();
        this.teacherList = new ArrayList<Teacher>();
    }

    public String getTeamId() {

        return teamId;
    }

    public String getTeamName() {

        return teamName;
    }

    public String getDepartment() {

        return department;
    }

    public Student getCreator() {

        return creator;
    }
    
    public String toString() {

        return new StringBuilder()
        .append("Team\n").append('\n')
        .append("\nteamName: ").append(teamName)         
        .append("\ndepartment: ").append(department)      
        .append("\ncreator: ").append(creator.getName())
        .toString();
    }

    public List<Student> getStudentList() {

        return studentList;
    }

    public List<Teacher> getTeacherList() {

        return teacherList;
    }

    public void addStudent(Student student) {

        studentList.add(student);
    }

    public void addTeacher(Teacher teacher) {

        teacherList.add(teacher);
    }
}
