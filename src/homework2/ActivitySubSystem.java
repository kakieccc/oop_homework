package homework2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ActivitySubSystem {

    private ArrayList<Activity> activityList;

    public ActivitySubSystem() {

        this.activityList = new ArrayList<Activity>();
    }
    public void addActivity(Activity activity) {

        activityList.add(activity);
    }

    public void removeActivityById(String id) {
        
        for(int i = 0; i < activityList.size(); i++) {
            if(activityList.get(i).getId() == id) {
                activityList.remove(i);
            }
        }
    }

    public Activity getActivityById(String id) {

        for(int i = 0; i < activityList.size(); i++) {
            if(activityList.get(i).getId() == id) {
                return activityList.get(i);
            }
        }
        return null;
    }

    public List<Activity> getActivitiesByDate(Date date) {

        return activityList.stream().filter(activity -> (
        activity.getStartTime().before(date) &&
        activity.getEndTime().after(date)
      )).collect(Collectors.toList());
    }

    public ArrayList<Activity> getActivityList() {

        return activityList;
    }

    public boolean checkActivityNumOfTeam(String teamId) {

        long count = activityList.stream().filter(activity -> {
        Spliterator<Team> spliterator = Spliterators.spliteratorUnknownSize(activity.getTeamsIterator(), 0);
        return StreamSupport.stream(spliterator, false)
          .anyMatch(team -> team.getTeamId().equals(teamId));
      }).count();

        return count == 1;
    }
}
