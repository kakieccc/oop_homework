package indi.homework.comparator;

import java.util.Comparator;
import indi.homework.student.*;

public class DoctoralComparator implements Comparator<DoctoralStudent> {
    public int compare(DoctoralStudent s1, DoctoralStudent s2) {
        if (s1.getBirthday() == s2.getBirthday())
            return 0;
        else if (s1.getBirthday().after(s2.getBirthday()))
            return -1;
        else
            return 1;
    }
}
