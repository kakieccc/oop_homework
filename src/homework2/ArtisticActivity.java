package homework2;

import java.util.Date;

public class ArtisticActivity extends Activity{

    private String type;

    public ArtisticActivity(String initialId, String initialName, Date initialStartTime, Date initialEndTime, String initialDescription, String initialSite, String initialType) {
        
        super(initialId, initialName, initialStartTime, initialEndTime, initialDescription, initialSite);
        this.type = initialType;
    }

    public String getType() {

        return type;
    }

    public String toString() {

        return new StringBuilder()
        .append("- ArtisticActivity\n")
        .append("  id: ")         .append(getId())         .append('\n')
        .append("  name: ")       .append(getName())       .append('\n')
        .append("  startTime: ")  .append(getStartTime())  .append('\n')
        .append("  endTime: ")    .append(getEndTime())    .append('\n')
        .append("  description: ").append(getDescription()).append('\n')
        .append("  site: ")       .append(getSite())       .append('\n')
        .append("  type: ")       .append(type)            .append('\n')
        .toString();
    }
}
