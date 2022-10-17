package homework2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class Activity {

    private String id;
    private String name;
    private Date startTime;
    private Date endTime;
    private String description;
    private String site;

    private List<Team> teamList;
    private List<Teacher> teacherList;
    private List<Organizer> organizerList;

    public Activity(String initialId, String initialName, Date initialStartTime, Date initialEndTime, String initialDescription, String initialSite) {
        
        this.id = initialId;
        this.name = initialName;
        this.startTime = initialStartTime;
        this.endTime = initialEndTime;
        this.description = initialDescription;
        this.site = initialSite;
        this.teamList = new ArrayList<Team>();
        this.teacherList = new ArrayList<Teacher>();
        this.organizerList = new ArrayList<Organizer>();
    }

    public String getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public Date getStartTime() {

        return startTime;
    }

    public Date getEndTime() {

        return endTime;
    }

    public String getDescription() {

        return description;
    }

    public String getSite() {

        return site;
    }

    public void setDescription(String changeDescription) {

        description = changeDescription;
    }

    public void addTeamToActivity(Team team) {
        
        teamList.add(team);
    }

    public void removeTeamFromActivity(String id) {

        for(Team team : teamList) {
            if(id.equals(team.getTeamId())) {
                teamList.remove(team);
            }
        }
    }

    public void addTeacherToActivity(Teacher teacher) {

        teacherList.add(teacher);
    }

    public void removeTeacherFromActivity(String id) {
        
        for(Teacher teacher : teacherList) {
            if(id.equals(teacher.getId())) {
                teacherList.remove(teacher);
            }
        }
    }

    public void addOrganizerToActivity(Organizer organizer) {

        organizerList.add(organizer);
    }

    public void removeOrganizerFromActivity(String id) {
        
        for(Organizer organizer : organizerList) {
            if(id.equals(organizer.getId())) {
                organizerList.remove(organizer);
            }
        }
    }

    public String toString() {

        return new StringBuilder()
        .append("- Activity\n")
        .append("  id: ")         .append(id)         .append('\n')
        .append("  name: ")       .append(name)       .append('\n')
        .append("  startTime: ")  .append(startTime)  .append('\n')
        .append("  endTime: ")    .append(endTime)    .append('\n')
        .append("  description: ").append(description).append('\n')
        .append("  site: ")       .append(site)       .append('\n')
        .toString();
    }

    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Activity activity = (Activity)o;
        return id.equals(activity.getId());
    }

    public Iterator<Team> getTeamsIterator() {
        return teamList.iterator();
    }
    public Iterator<Teacher> getTeachersIterator() {
        return teacherList.iterator();
    }
    public Iterator<Organizer> getOrganizersIterator() {
        return organizerList.iterator();
    }

}
