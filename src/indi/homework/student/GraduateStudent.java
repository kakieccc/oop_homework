package indi.homework.student;

import java.util.Date;
import indi.homework.*;

public class GraduateStudent extends StudentInfo{
    
    private String supervisor;

    public GraduateStudent(String studentNumber, String studentName, String gender, Date birthday, String academy, String major, String supervisor) {

        super(studentNumber, studentName, gender, birthday, academy, major);
        this.supervisor = supervisor;
    }

    public String getSupervisor() {

        return supervisor;
    }

    public String toString() {

        String str = null;
        str = "{\"academy\":\"" + getAcademy() + "\","
            + "\"birthday\":\"" + StudentManagementSystem.dateFormat.format(getBirthday()) + "\","
            + "\"gender\":\"" + getGender() + "\","
            + "\"major\":\"" + getMajor() + "\","
            + "\"studentName\":\"" + getStudentName() + "\","
            + "\"studentNumber\":\"" + getStudentNumber() + "\","
            + "\"supervisor\":\"" + getSupervisor() + "\"}";
        return str;

    }
}
