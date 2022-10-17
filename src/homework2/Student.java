package homework2;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{

    private String studentNo;
    private boolean gender;
    private String grade;
    private String department;
    private List<Team> teamList;

    public Student(
        String initialId, 
        String initialName, 
        String initialPhoneNo, 
        String initialEmail, 
        String initialStudentNo, 
        boolean initialGender, 
        String initialGrade, 
        String initialDepartment) {
        super(initialId, initialName, initialPhoneNo, initialEmail);
        this.studentNo = initialStudentNo;
        this.gender = initialGender;
        this.grade = initialGrade;
        this.department = initialDepartment;
        this.teamList = new ArrayList<Team>();
    }

    public String getStudentNo() {

        return studentNo;
    }

    public boolean getGender() {

        return gender;
    }

    public String getGrade() {

        return grade;
    }

    public String getDepartment() {

        return department;
    }

    public List<Team> getTeamList() {

        return teamList;
    }

    public String toString() {

        return new StringBuilder()
        .append("\nid: ").append(getId())
        .append("\nname: ").append(getName())
        .append("\nphoneNo: ").append(getPhoneNo())
        .append("\nemail: ").append(getEmail())
        .append("\nstudentNo: ").append(studentNo)            
        .append("\ngender: ").append(gender ? "Female" : "Male")
        .append("\ngrade: ").append(grade)                 
        .append("\ndepartment: ").append(department)               
        .toString();
    }
}
