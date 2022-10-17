package homework2;

import java.util.ArrayList;
import java.util.List;

public class UserSubSystem {

  private List<User> userList;

  public UserSubSystem() {

    this.userList = new ArrayList<User>();
  }

  public void addStudent(Student student) {

    userList.add(student);
  }

  public void removeStudentById(String id) {

    for(int i = 0; i < userList.size(); i++) {
      if(userList.get(i).getId() == id && userList.get(i) instanceof Student) {
        userList.remove(i);
      }
    }
  }

  public Student getStudentById(String id) {

    for(int i = 0; i < userList.size(); i++) {
      if(userList.get(i).getId() == id && userList.get(i) instanceof Student) {
        return (Student)userList.get(i);
      }
    }
    return null;
  }

  public List<Student> getStudentList() {
    List<Student> stuList = new ArrayList<Student>();
    for(int i = 0; i < userList.size(); i++) {
      if(userList.get(i) instanceof Student) {
        stuList.add((Student) userList.get(i));
        return stuList;
      }
    }
    return null;
  }

  public void addOrganizer(Organizer organizer) {

    userList.add(organizer);
  }

  public void removeOrganizerById(String id) {

    for(int i = 0; i < userList.size(); i++) {
      if(userList.get(i).getId() == id && userList.get(i) instanceof Organizer) {
        userList.remove(i);
      }
    }
  }

  public Organizer getOrganizerById(String id) {

    for(int i = 0; i < userList.size(); i++) {
      if(userList.get(i).getId() == id && userList.get(i) instanceof Organizer) {
        return (Organizer)userList.get(i);
      }
    }
    return null;
  }

  public List<Organizer> getOrganizerList() {

    List<Organizer> orgList = new ArrayList<Organizer>();
    for(int i = 0; i < userList.size(); i++) {
      if(userList.get(i) instanceof Organizer) {
        orgList.add((Organizer) userList.get(i));
        return orgList;
      }
    }
    return null;
  }

  public void addTeacher(Teacher teacher) {

    userList.add(teacher);
  }

  public void removeTeacherById(String id) {

    for(int i = 0; i < userList.size(); i++) {
      if(userList.get(i).getId() == id && userList.get(i) instanceof Teacher) {
        userList.remove(i);
      }
    }
  }

  public Teacher getTeacherById(String id) {

    for(int i = 0; i < userList.size(); i++) {
      if(userList.get(i).getId() == id && userList.get(i) instanceof Teacher) {
        return (Teacher)userList.get(i);
      }
    }
    return null;
  }

  public List<Teacher> getTeacherList() {

    List<Teacher> teaList = new ArrayList<Teacher>();
    for(int i = 0; i < userList.size(); i++) {
      if(userList.get(i) instanceof Teacher) {
        teaList.add((Teacher) userList.get(i));
        return teaList;
      }
    }
    return null;
  }

  public void createTeam(

    String creatorId,
    String teamId,
    String teamName,
    String department
  ) {
    Student creator = getStudentById(creatorId);

    Team newTeam = new Team(teamId, teamName, department, creator);
    newTeam.addStudent(creator);

    creator.getTeamList().add(newTeam);
  }

  public void addStudentToTeam(String creatorId, String studentId, String teamId) {
    Student creator = getStudentById(creatorId);

    Team team = creator.getTeamList().stream()
      .filter(t -> t.getTeamId().equals(teamId))
      .findFirst()
      .orElse(null);

    if (team != null) {
      Student student = getStudentById(studentId);
      team.addStudent(student);
    }
  }

  public void addTeacherToTeam(String creatorId, String teacherId, String teamId) {
    Student creator = getStudentById(creatorId);

    Team team = creator.getTeamList().stream()
      .filter(t -> t.getTeamId().equals(teamId))
      .findFirst()
      .orElse(null);

    if (team != null) {
      Teacher teacher = getTeacherById(teacherId);
      team.addTeacher(teacher);
    }
  }
}