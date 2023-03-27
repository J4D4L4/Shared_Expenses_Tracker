package splitter.Objects;

import java.util.ArrayList;
import java.util.List;

public class Group {
    List<Person> members;
    String name;

    public Group(String name){

        this.name = name;
        this.members = new ArrayList<>();
    }
    Group(String name, List<Person> members){
        this.name = name;
        this.members = members;
    }

    public void addPerson(Person person){
        members.add(person);
    }
    public void removePerson(Person person){
        members.remove(person);
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void print(){
        for(Person person : members){
            System.out.println(person.getName());
        }
    }
}