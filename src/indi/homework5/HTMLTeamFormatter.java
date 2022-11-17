package indi.homework5;

/**
 * @author llh
 * @date 2022/10/29
 */
public class HTMLTeamFormatter implements TeamFormatter{
    
    private static HTMLTeamFormatter singletonInstance;

    public HTMLTeamFormatter() {
        
    }

    public static HTMLTeamFormatter getSingletonInstance() {

        singletonInstance = new HTMLTeamFormatter();
        return singletonInstance;
    }

    @Override
    public String formatTeam(Team team) {

        Student creator = team.getCreator();
        StringBuilder str = new StringBuilder();
        str .append("<html>" + "\n\n")
            .append("\t<body>" + "\n\n")
            .append("\t\t<center><h2>Team Information</h2></center>" + "\n\n")
            .append("\t\t" + team.getTeamId() + " ")
            .append(team.getTeamName() + " ")
            .append(team.getDepartment() + "<br>" + "\n\n")
            .append("\t\tcreator[")
            .append(creator.getId() + " ")
            .append(creator.getName() + " ")
            .append(creator.getPhoneNo() + " ")
            .append(creator.getEmail() + " ")
            .append(creator.getStudentNo() + " ")
            .append((creator.getGender() == true ? "女" : "男") + " ")
            .append(creator.getGrade() + " ")
            .append(creator.getDepartment() + "]<br>" + "\n\n")
            .append("\t\t<h3>StudentList</h3>" + "\n\n")
            .append("\t\t<blockquote>" + "\n\n");
        for (Student student : team.getStudentList()) {
            str .append("\t\t\t" + student.getId() + " ")
                .append(student.getName() + " ")
                .append(student.getPhoneNo() + " ")
                .append(student.getEmail() + " ")
                .append(student.getStudentNo() + " ")
                .append((student.getGender() == true ? "女" : "男") + " ")
                .append(student.getGrade() + " ")
                .append(student.getDepartment() + "<br>" + "\n\n");
        }
        str .append("\t\t</blockquote>" + "\n\n")
            .append("\t\t<h3>TeacherList</h3>" + "\n\n")
            .append("\t\t<blockquote>" + "\n\n");
        for (Teacher teacher : team.getTeacherList()) {
            str .append("\t\t\t" + teacher.getId() + " ")
                .append(teacher.getName() + " ")
                .append(teacher.getPhoneNo() + " ")
                .append(teacher.getEmail() + " ")
                .append(teacher.getTeacherNo() + " ")
                .append(teacher.getDepartment() + "<br>" + "\n\n");
        }
        str .append("\t\t</blockquote>" + "\n\n")
            .append("\t</body>" + "\n\n" + "</html>" + "\n\n");
        return str.toString();
    }
}
