package indi.homework.comparator;

import java.util.Comparator;
import indi.homework.student.*;

public class UndergraduateComparator implements Comparator<UndergraduateStudent> {
    public int compare(UndergraduateStudent s1, UndergraduateStudent s2) {
        if (s1.getBirthday() == s2.getBirthday())
            return 0;
        else if (s1.getBirthday().after(s2.getBirthday()))
            return -1;
        else
            return 1;
    }
}
