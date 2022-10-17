package homework2;

public class User {

    private String id;
    private String name;
    private String phoneNo;
    private String email;

    public User(String initialId, String initialName, String initialPhoneNo, String initialEmail) {

        this.id = initialId;
        this.name = initialName;
        this.phoneNo = initialPhoneNo;
        this.email = initialEmail;
    }

    public String getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public String getPhoneNo() {

        return phoneNo;
    }

    public String getEmail() {

        return email;
    }

    public String setEmail(String changeemail) {

        email = changeemail;
        return email;
    }

    public String setName(String changename) {

        name = changename;
        return name;
    }

    public String toString() {
        
        return new StringBuilder()
        .append("User\n")
        .append("\nid: ").append(id)     
        .append("\nname: ").append(name)  
        .append("\nphoneNo: ").append(phoneNo)
        .append("\nemail: ").append(email) 
        .toString();
    }

    public boolean equals(User o1, User o2) {
        if(o1.id != o2.id) {
            return false;
        }
        else {
            return true;
        }
    }
}
