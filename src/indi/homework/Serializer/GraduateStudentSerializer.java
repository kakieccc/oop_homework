package indi.homework.Serializer;

import com.alibaba.fastjson2.JSON;
import java.util.ArrayList;
import indi.homework.student.*;

public class GraduateStudentSerializer {
    public static String serializer(ArrayList<GraduateStudent> students) {
        return JSON.toJSONString(students);
    }

    public static ArrayList<GraduateStudent> deserialize(String json) {
        return (ArrayList<GraduateStudent>) JSON.parseArray(json, GraduateStudent.class);
    }
}
