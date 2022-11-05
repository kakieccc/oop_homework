package indi.homework.Serializer;

import indi.homework.StudentManagementSystem;
import indi.homework.student.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.Iterator;

public class DoctoralStudentSerializer {
    public static String serializer(ArrayList<DoctoralStudent> students) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("doctoralStudents");

        for (DoctoralStudent student : students) {
            Element studentElement = root.addElement("studentInfo");
            studentElement.addElement("studentNumber").addText(student.getStudentNumber());
            studentElement.addElement("studentName").addText(student.getStudentName());
            studentElement.addElement("gender").addText(student.getGender());
            studentElement.addElement("birthday").addText(StudentManagementSystem.dateFormat.format(student.getBirthday()));
            studentElement.addElement("academy").addText(student.getAcademy());
            studentElement.addElement("major").addText(student.getMajor());
            studentElement.addElement("supervisor").addText(student.getSupervisor());
            studentElement.addElement("researchFields").addText(student.getResearchFields());
        }

        return document.asXML();
    }

    public static ArrayList<DoctoralStudent> deserialize(String xml) throws DocumentException, ParseException {
        Document document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();
        ArrayList<DoctoralStudent> students = new ArrayList<>();

        for (Iterator<Element> it = root.elementIterator(); it.hasNext(); ) {
            Element studentElement = it.next();
            DoctoralStudent student = new DoctoralStudent(
                    studentElement.elementText("studentNumber"),
                    studentElement.elementText("studentName"),
                    studentElement.elementText("gender"),
                    StudentManagementSystem.dateFormat.parse(studentElement.elementText("birthday")),
                    studentElement.elementText("academy"),
                    studentElement.elementText("major"),
                    studentElement.elementText("supervisor"),
                    studentElement.elementText("researchFields")
                    );
            students.add(student);
        }

        return students;
    }
}
