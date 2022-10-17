package homework2;

import java.util.Date;

public class PartyActivity extends Activity{

    private String theme;
    private String classification;

    public PartyActivity(String initialId, String initialName, Date initialStartTime, Date initialEndTime, String initialDescription, String initialSite, String initialTheme, String initialClassification) {
        
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
        .append("- PartyActivity\n")
        .append("  id: ")            .append(getId())         .append('\n')
        .append("  name: ")          .append(getName())       .append('\n')
        .append("  startTime: ")     .append(getStartTime())  .append('\n')
        .append("  endTime: ")       .append(getEndTime())    .append('\n')
        .append("  description: ")   .append(getDescription()).append('\n')
        .append("  site: ")          .append(getSite())       .append('\n')
        .append("  theme: ")         .append(theme)           .append('\n')
        .append("  classification: ").append(classification)  .append('\n')
        .toString();
    }
    
}
