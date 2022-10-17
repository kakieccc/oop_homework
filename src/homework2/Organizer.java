package homework2;

public class Organizer extends User{

    private String unit;

    public Organizer(
        String initialId, 
        String initialName, 
        String initialPhoneNo, 
        String initialEmail, 
        String initialUnit) {
        super(initialId, initialName, initialPhoneNo, initialEmail);
        this.unit = initialUnit;
    }
 
    public String getUnit() {

        return unit;
    }

    public String toString() {

        return new StringBuilder()
        .append("Organizer\n")
        .append("\nid: ").append(getId())     
        .append("\nname: ").append(getName())   
        .append("\nphoneNo: ").append(getPhoneNo())
        .append("\nemail: ").append(getEmail()) 
        .append("\nunit: ").append(unit)
        .toString();
    
    }

}
