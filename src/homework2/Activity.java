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

    public Activity(
        String initialId, 
        String initialName, 
        Date initialStartTime, 
        Date initialEndTime, 
        String initialDescription, 
        String initialSite) {
        
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

        for(int i = 0; i < teamList.size(); i++) {
            if(teamList.get(i).getTeamId() == id) {
                teamList.remove(i);
            }
        }
    }

    public void addTeacherToActivity(Teacher teacher) {

        teacherList.add(teacher);
    }

    public void removeTeacherFromActivity(String id) {
        
        for(int i = 0; i < teacherList.size(); i++) {
            if(teacherList.get(i).getId() == id) {
                teacherList.remove(i);
            }
        }
    }

    public void addOrganizerToActivity(Organizer organizer) {

        organizerList.add(organizer);
    }

    public void removeOrganizerFromActivity(String id) {
        
        for(int i = 0; i < organizerList.size(); i++) {
            if(organizerList.get(i).getId() == id) {
                organizerList.remove(i);
            }
        }
    }

    public String toString() {

        return new StringBuilder()
        .append("id: ").append(id)         
        .append("\nname: ").append(name)       
        .append("\nstartTime: ").append(startTime)  
        .append("\nendTime: ").append(endTime)    
        .append("\ndescription: ").append(description)
        .append("\nsite: ").append(site)       
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
