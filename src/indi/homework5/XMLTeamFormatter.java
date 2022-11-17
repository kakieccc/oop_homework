package indi.homework5;

/**
 * @author llh
 * @date 2022/10/29
 */
public class XMLTeamFormatter implements TeamFormatter{
    
    private static XMLTeamFormatter singletonInstance;

    public XMLTeamFormatter() {
        
    }

    public static XMLTeamFormatter getSingletonInstance() {

		singletonInstance = new XMLTeamFormatter();
        return singletonInstance;
    }

    @Override
    public String formatTeam(Team team) {

        Student creator = team.getCreator();
        StringBuilder str = new StringBuilder();
		str .append("<Team ")
		    .append("teamId=\"" + team.getTeamId() + "\" ")
		    .append("teamName=\"" + team.getTeamName() + "\" ")
            .append("department=\"" + team.getDepartment() + "\">" + "\n\n")
            .append("\t<Creator ")
            .append("id=\"" + creator.getId() + "\" ")
            .append("name=\"" + creator.getName() + "\" ")
            .append("phoneNo=\"" + creator.getPhoneNo() + "\" ")
            .append("email=\"" + creator.getEmail() + "\" ")
            .append("studentNo=\"" + creator.getStudentNo() + "\" ")
			.append("gender=\"" + (creator.getGender() == true ? "女" : "男") + "\"")
			.append("grade=\"" + creator.getGrade() + "\" ")
		    .append("department=\"" + creator.getDepartment() + "\"/>" + "\n\n")
		    .append("\t<StudentList>" + "\n\n");
		for (Student student : team.getStudentList()) {
			str.append("\t\t<Student ")
			.append("id=\"" + student.getId() + "\" ")
			.append("name=\"" + student.getName() + "\" ")
			.append("phoneNo=\"" + student.getPhoneNo() + "\" ")
			.append("email=\"" + student.getEmail() + "\" ")
			.append("studentNo=\"" + student.getStudentNo() + "\" ")
			.append("gender=\"" + (student.getGender() == true ? "女" : "男") + "\"")
			.append("grade=\"" + student.getGrade() + "\" ")
			.append("department=\"" + student.getDepartment() + "\"/>" + "\n\n");
		}
		str .append("\t</StudentList>" + "\n\n")
		    .append("\t<TeacherList>" + "\n\n");
		for (Teacher teacher : team.getTeacherList()) {
			str .append("\t\t<Teacher ")
			    .append("id=\"" + teacher.getId() + "\" ")
                .append("name=\"" + teacher.getName() + "\" ")
                .append("phoneNo=\"" + teacher.getPhoneNo() + "\" ")
                .append("email=\"" + teacher.getEmail() + "\" ")
                .append("teacherNo=\"" + teacher.getTeacherNo() + "\" ")
                .append("department=\"" + teacher.getDepartment() + "\"/>" + "\n\n");
		}
		str .append("\t</TeacherList>" + "\n\n")
		    .append("</Team>" + "\n\n");
		return str.toString();
    }
}
