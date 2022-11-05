package indi.homework.student;

import java.util.Date;
import org.dom4j.*;
import indi.homework.*;

public class DoctoralStudent extends StudentInfo{
    
    private String supervisor;
    private String researchFields;

    public DoctoralStudent(String studentNumber, String studentName, String gender, Date birthday, String academy, String major, String supervisor, String researchFields) {

        super(studentNumber, studentName, gender, birthday, academy, major);
        this.supervisor = supervisor;
        this.researchFields = researchFields;
    }

    public String getSupervisor() {

        return supervisor;
    }

    public String getResearchFields() {

        return researchFields;
    }

    public String toString() {
        Document doc = DocumentHelper.createDocument();
        Element ele = doc.addElement("studentInfo");
        ele.addElement("studentNumber").setText(getStudentNumber());
        ele.addElement("studentName").setText(getStudentName());
        ele.addElement("gander").setText(String.valueOf(getGender()));
        ele.addElement("birthday").setText(StudentManagementSystem.dateFormat.format(getBirthday()));
        ele.addElement("academy").setText(getAcademy());
        ele.addElement("major").setText(getMajor());
        ele.addElement("supervisor").setText(getSupervisor());
        ele.addElement("researchFields").setText(getResearchFields());
        return doc.asXML();
    }
}
