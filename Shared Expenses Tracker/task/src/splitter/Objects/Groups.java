package splitter.Objects;

import java.util.List;
import java.util.ArrayList;

public class Groups {

    static Groups instance;
    List<Group> groups;

    Groups(){
        this.groups = new ArrayList<>();
    }

    public static Groups getInstance() {
        if(instance == null){
            instance = new Groups();
        }
        return instance;
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    public  void removeGroup(Group group){
        groups.remove(group);
    }
    public Group getByName(String name){
        for(Group group : groups){
            if(group.getName().equals(name)){
                return group;
            }
        }
        return null;
    }
    public boolean nameExists(String name){
        for(Group group : groups){
            if(group.getName().equals(name)){
                return true;
            }
        }
        return false;
    }


}

