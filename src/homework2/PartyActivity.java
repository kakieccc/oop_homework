package homework2;

import java.util.Date;

public class PartyActivity extends Activity{

    private String theme;
    private String classification;

    public PartyActivity(
        String initialId, 
        String initialName, 
        Date initialStartTime, 
        Date initialEndTime,
        String initialDescription,
        String initialSite, 
        String initialTheme, 
        String initialClassification) {
        
        super(initialId, initialName, initialStartTime, initialEndTime, initialDescription, initialSite);
        this.theme =initialTheme;
        this.classification = initialClassification;
    }

    public String getTheme() {

        return theme;
    }

    public String getClassification() {

        return classification;
    }

    public String toString() {

        return new StringBuilder()
        .append("PartyActivity\n")
        .append("\nid: ").append(getId())         
        .append("\nname: ").append(getName())       
        .append("\nstartTime: ").append(getStartTime())
        .append("\nendTime: ").append(getEndTime())    
        .append("\ndescription: ").append(getDescription())
        .append("\nsite: ").append(getSite())       
        .append("\ntheme: ").append(theme)           
        .append("\nclassification: ").append(classification)  
        .toString();
    }
    
}
