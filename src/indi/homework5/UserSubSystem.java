package indi.homework5;

/**
 * @author llh
 * @date 2022/11/5
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class UserSubSystem {

	private static final String PATHNAME = "./team.dat";
	private static TeamFormatter teamFormatter;

	/**
	 * Initialize instance variable team
	 */
	public UserSubSystem() {
		
	}

	/**
	 * Starts the application
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		UserSubSystem userSubSystem = new UserSubSystem();
		userSubSystem.run();
	}

	/**
	 * Present the user with a menu of options and execute the selected task
	 *
	 * @throws IOException
	 */
	public void run() throws IOException {

		displayTeam();
	}

	/**
	 * Change the current formatter by updating the instance variable teamFormatter
	 * with the object specified in the parameter formatter
	 *
	 * @param formatter
	 */
	public static void setTeamFormatter(TeamFormatter formatter) {

		teamFormatter = formatter;
	}

	/**
	 * 读入dat文件并转化为字符串
	 */
	public static String loadTeam() {

		StringBuffer content = new StringBuffer();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(PATHNAME),"UTF-8"));
			String line = null;
			while((line = br.readLine()) != null) {
				content.append(line)
					   .append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return content.toString();
	}

	/**
	 * Display the team information in the standard output using the method
	 * teamFormatter.formatTeam() to obtain the team information in the current
	 * format
	 */
	public static String displayTeam() {
		
		setTeamFormatter(XMLTeamFormatter.getSingletonInstance());
		ArrayList<Team> teamList = deserialize(loadTeam());
		StringBuilder s = new StringBuilder();
		for(Team team : teamList) {
			s.append(teamFormatter.formatTeam(team));
		}
		return s.toString();
	}

	/**
	 * 将dat文件读入的字符串反序列化为teamList
	 * @param str
	 * @return teamList
	 */
	public static ArrayList<Team> deserialize(String str) {

		ArrayList<Team> teamList = new ArrayList<>();
		ArrayList<Student> studentList = new ArrayList<>();
		ArrayList<Teacher> teacherList = new ArrayList<>();

		try {
			String[] lines = str.split("\n");
			for(String line : lines) {
				//跳过dat中的空行
				if(line.length() == 0){
					continue;
				}
				Teacher teacher = null;
				Student student = null;
				Student creator = null;
				String[] content = line.split("_");
				for(int i = 0; i < content.length; i++) {
					if(content[i].equals("Teacher")) {
						teacher = new Teacher(
							content[i+1], 
							content[i+2], 
							content[i+3], 
							content[i+4], 
							content[i+5], 
							content[i+6]);
						teacherList.add(teacher);
					}
					else if(content[i].equals("Student")) {
						student = new Student(
							content[i+1], 
							content[i+2], 
							content[i+3], 
							content[i+4], 
							content[i+5], 
							(content[i+6].equals("女")) ? true : false, 
							content[i+7], 
							content[i+8]);
						studentList.add(student);
					}
					else if(content[i].equals("Creator")) {
						creator = new Student(
							content[i+1], 
							content[i+2], 
							content[i+3], 
							content[i+4], 
							content[i+5], 
							(content[i+6].equals("女")) ? true : false, 
							content[i+7], 
							content[i+8]);
					}
				}
				Team team = new Team(
					content[1], 
					content[2], 
					content[3], 
					creator);
				for(Student person : studentList) {
					team.addStudent(person);
				}
				for(Teacher person : teacherList) {
					team.addTeacher(person);
				}
				teamList.add(team);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return teamList;
	}
}
