package indi.homework.Serializer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Formatter;

import indi.homework.StudentManagementSystem;
import indi.homework.student.*;

public class UndergraduateStudentSerializer {

    public static String serializer(ArrayList<UndergraduateStudent> students) {
        StringBuilder sb = new StringBuilder();
        for (UndergraduateStudent student : students) {
            Formatter fmt = new Formatter();
            fmt.format("%s_%s_%s_%s_%s_%s_%s",
                    student.getStudentNumber(),
                    student.getStudentName(),
                    student.getGender(),
                    StudentManagementSystem.dateFormat.format(student.getBirthday()),
                    student.getAcademy(),
                    student.getMajor(),
                    student.getTutor()
            );
            sb.append(fmt + "\n");
        }

        return sb.toString();
    }

    public static ArrayList<UndergraduateStudent> deserialize(String string) throws ParseException {
        ArrayList<UndergraduateStudent> students = new ArrayList<>();
        String[] lines = string.split("\n");
        for (String line : lines) {
            String[] fields = line.split("_");
            UndergraduateStudent student = new UndergraduateStudent(
                    fields[0],
                    fields[1],
                    fields[2],
                    StudentManagementSystem.dateFormat.parse(fields[3]),
                    fields[4],
                    fields[5],
                    fields[6]
            );
            students.add(student);
        }

        return students;
    }

}
