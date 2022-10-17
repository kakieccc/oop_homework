package homework2;

import java.util.Date;

public class LectureActivity extends Activity{

    private String keySpeaker;

    public LectureActivity(
        String initialId, 
        String initialName,
        Date initialStartTime,
        Date initialEndTime,
        String initialDescription,
        String initialSite,
        String initialKeySpeaker) {
        
        super(initialId, initialName, initialStartTime, initialEndTime, initialDescription, initialSite);
        this.keySpeaker = initialKeySpeaker;
    }

    public String getKeySpeaker() {

        return keySpeaker;
    }

    public String toString() {

        return new StringBuilder()
        .append("LectureActivity\n")
        .append("\nid: ").append(getId())        
        .append("\nname: ").append(getName())       
        .append("\nstartTime: ").append(getStartTime())  
        .append("\nendTime: ").append(getEndTime())    
        .append("\ndescription: ").append(getDescription())
        .append("\nsite: ").append(getSite())       
        .append("\nkeySpeaker: ").append(keySpeaker)     
        .toString();
    }
}
