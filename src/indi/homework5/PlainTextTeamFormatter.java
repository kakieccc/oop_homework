package indi.homework5;
/**
 * @author llh
 * @date 2022/10/29
 */
public class PlainTextTeamFormatter implements TeamFormatter{

    private static PlainTextTeamFormatter singletonInstance;

    public PlainTextTeamFormatter() {

    }

    public static PlainTextTeamFormatter getSingletonInstance() {

        singletonInstance = new PlainTextTeamFormatter();
		return singletonInstance;
	}

    @Override
    public String formatTeam(Team team) {
        
        Student creator = team.getCreator();
        StringBuilder str = new StringBuilder();
        str .append("Team {" + "\n\n")
            .append("\tteamId : " + team.getTeamId() + "\n\n")
            .append("\tteamName : " + team.getTeamName() + "\n\n")
            .append("\tdepartment : " + team.getDepartment() + "\n\n")
            .append("\tcreator {" + "\n\n")
            .append("\t\tid : " + creator.getId() + "\n\n")
            .append("\t\tname : " + creator.getName() + "\n\n")
            .append("\t\tphoneNo : " + creator.getPhoneNo() + "\n\n")
            .append("\t\temail : " + creator.getEmail() + "\n\n")
            .append("\t\tstudentNo : " + creator.getStudentNo() + "\n\n")
            .append("\t\tgender : " + (creator.getGender() == true ? "女" : "男") + "\n\n")
            .append("\t\tgrade : " + creator.getGrade() + "\n\n")
            .append("\t\tdepartment : " + creator.getDepartment() + "\n\n")
            .append("\t}" + "\n\n")
            .append("\tstudentList {" + "\n\n");
        for (Student student : team.getStudentList()) {
            str .append("\t\tstudent {" + "\n\n")
                .append("\t\t\tid : " + student.getId() + "\n\n")
                .append("\t\t\tname : " + student.getName() + "\n\n")
                .append("\t\t\tphoneNo : " + student.getPhoneNo() + "\n\n")
                .append("\t\t\temail : " + student.getEmail() + "\n\n")
                .append("\t\t\tstudentNo : " + student.getStudentNo() + "\n\n")
                .append("\t\t\tgender : " + (student.getGender() == true ? "女" : "男") + "\n\n")
                .append("\t\t\tgrade : " + student.getGrade() + "\n\n")
                .append("\t\t\tdepartment : " + student.getDepartment() + "\n\n")
                .append("\t\t}" + "\n\n");
        }
        str .append("\t}" + "\n\n")
            .append("\tteacherList {" + "\n\n");
            for (Teacher teacher : team.getTeacherList()) {
                str .append("\t\tteacher {" + "\n\n")
                    .append("\t\t\tid : " + teacher.getId() + "\n\n")
                    .append("\t\t\tname : " + teacher.getName() + "\n\n")
                    .append("\t\t\tphoneNo : " + teacher.getPhoneNo() + "\n\n")
                    .append("\t\t\temail : " + teacher.getEmail() + "\n\n")
                    .append("\t\t\tteacherNo : " + teacher.getTeacherNo() + "\n\n")
                    .append("\t\t\tdepartment : " + teacher.getDepartment() + "\n\n")
                .append("\t\t}" + "\n\n");
            }
        str .append("\t}" + "\n\n")
            .append("}" + "\n\n");
		return str.toString();
    }
    
    
}
