package indi.homework.student;

import indi.homework.*;
import java.util.Date;

public class UndergraduateStudent extends StudentInfo{
    
    private String tutor;

    public UndergraduateStudent(String studentNumber, String studentName, String gender, Date birthday, String academy, String major, String tutor) {

        super(studentNumber, studentName, gender, birthday, academy, major);
        this.tutor = tutor;
    }

    public String getTutor() {

        return tutor;
    }

    public String toString() {

        StringBuilder str = new StringBuilder();
        str .append(getStudentNumber()).append("_")
            .append(getStudentName()).append("_")
            .append(getGender()).append("_")
            .append(StudentManagementSystem.dateFormat.format(getBirthday())).append("_")
            .append(getAcademy()).append("_")
            .append(getMajor()).append("_")
            .append(getTutor());
        return str.toString();
    }
}
