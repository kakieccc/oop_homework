package homework2;

import java.util.Date;

public class ArtisticActivity extends Activity{

    private String type;

    public ArtisticActivity(
        String initialId,
        String initialName, 
        Date initialStartTime, 
        Date initialEndTime, 
        String initialDescription, 
        String initialSite, 
        String initialType) {
        
        super(initialId, initialName, initialStartTime, initialEndTime, initialDescription, initialSite);
        this.type = initialType;
    }

    public String getType() {

        return type;
    }

    public String toString() {

        return new StringBuilder()
        .append("ArtisticActivity\n")
        .append("\nid: ").append(getId())         
        .append("\nname: ").append(getName())       
        .append("\nstartTime: ").append(getStartTime())  
        .append("\nendTime: ").append(getEndTime())   
        .append("\ndescription: ").append(getDescription())
        .append("\nsite: ").append(getSite())      
        .append("\ntype: ").append(type)           
        .toString();
    }
}
