package homework2;

public class Teacher extends User{
    
    private String teacherNo;
    private String department;

    public Teacher(String initialId, String initialName, String initialPhoneNo, String initialEmail, String initialTeacherNo, String initialDepartment) {

        super(initialId, initialName, initialPhoneNo, initialEmail);
        this.teacherNo = initialTeacherNo;
        this.department = initialDepartment;
    }

    public String getTeacherNo() {

        return teacherNo;
    }

    public String getDepartment() {

        return department;
    }

    public void setDepartment(String changedepartment) {

        department = changedepartment;
    }

    public String toString() {

        return new StringBuilder()
        .append("Teacher\n")
        .append("\nid: ").append(getId())     
        .append("\nname: ").append(getName())   
        .append("\nphoneNo: ").append(getPhoneNo())
        .append("\nemail: ").append(getEmail())  
        .append("\nteacherNo: ").append(teacherNo)  
        .append("\ndepartment: ").append(department) 
        .toString();
    }
}
