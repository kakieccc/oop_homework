package indi.homework5;

import java.util.ArrayList;

public class Team {
  private final String teamId;
  
  private String teamName;
  
  private String department;
  
  private final Student creator;
  
  private final ArrayList<Student> studentList;
  
  private final ArrayList<Teacher> teacherList;
  
  public Team(String teamId, String teamName, String department, Student creator) {
    this.teamId = teamId;
    this.teamName = teamName;
    this.department = department;
    this.creator = creator;
    this.studentList = new ArrayList<>();
    this.teacherList = new ArrayList<>();
  }
  
  public String getTeamId() {
    return this.teamId;
  }
  
  public String getTeamName() {
    return this.teamName;
  }
  
  public String getDepartment() {
    return this.department;
  }
  
  public Student getCreator() {
    return this.creator;
  }
  
  public ArrayList<Student> getStudentList() {
    return this.studentList;
  }
  
  public ArrayList<Teacher> getTeacherList() {
    return this.teacherList;
  }
  
  public void addStudent(Student student) {
    for (Student stu : this.studentList) {
      if (stu.getId().equals(student.getId()))
        return; 
    } 
    this.studentList.add(student);
  }
  
  public void addTeacher(Teacher teacher) {
    for (Teacher tea : this.teacherList) {
      if (tea.getId().equals(teacher.getId()))
        return; 
    } 
    this.teacherList.add(teacher);
  }
  
  public String toString() {
    return "Team{teamId='" + this.teamId + '\'' + ", teamName='" + this.teamName + '\'' + ", department='" + this.department + 
      '\'' + ", creator='" + this.creator + '\'' + ", studentList=" + this.studentList + '\'' + ", teacherList='" + 
      this.teacherList + '}';
  }
}
