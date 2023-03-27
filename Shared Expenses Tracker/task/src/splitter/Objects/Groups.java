package splitter.Objects;

import java.util.List;
import java.util.ArrayList;

public class Groups {

    Groups instance;
    List<Group> groups;

    Groups(){
        this.groups = new ArrayList<>();
    }

    public Groups getInstance() {
        if(this.instance == null){
            this.instance = new Groups();
        }
        return instance;
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    public  void removeGroup(Group group){
        groups.remove(group);
    }
}

