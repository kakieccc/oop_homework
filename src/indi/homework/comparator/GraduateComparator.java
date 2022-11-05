package indi.homework.comparator;

import java.util.Comparator;
import indi.homework.student.*;

public class GraduateComparator implements Comparator<GraduateStudent> {
    public int compare(GraduateStudent s1, GraduateStudent s2) {
        if (s1.getBirthday() == s2.getBirthday())
            return 0;
        else if (s1.getBirthday().after(s2.getBirthday()))
            return -1;
        else
            return 1;
    }
}
