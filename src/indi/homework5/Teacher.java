package indi.homework5;

public class Teacher extends User {
    private final String teacherNo;
    
    private String department;
    
    public Teacher(String id, String name, String phoneNo, String email, String teacherNo, String department) {
      super(id, name, phoneNo, email);
      this.teacherNo = teacherNo;
      this.department = department;
    }
    
    public String getTeacherNo() {
      return this.teacherNo;
    }
    
    public String getDepartment() {
      return this.department;
    }
    
    public String toString() {
      return "Teacher{id='" + getId() + '\'' + ", name='" + getName() + '\'' + ", phoneNo='" + getPhoneNo() + 
        '\'' + ", email='" + getEmail() + '\'' + ", teacherNo='" + this.teacherNo + '\'' + ", department='" + 
        this.department + '\'' + '}';
    }
    
    public boolean equals(Object o) {
      if (this == o)
        return true; 
      if (o == null || getClass() != o.getClass())
        return false; 
      Teacher teacher = (Teacher)o;
      return this.teacherNo.equals(teacher.teacherNo);
    }
  }
  