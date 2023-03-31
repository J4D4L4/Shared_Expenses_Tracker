package splitter.Objects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        sortGroupMembers();
    }

    public void addPerson(Person person){
        members.add(person);
        sortGroupMembers();
    }
    public void removePerson(Person person){
        members.remove(person);
    }

    public List<Person> getMembers() {

        sortGroupMembers();
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

    void sortGroupMembers(){
        members = members.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
    }

    public void print(){
        for(Person person : members.stream().sorted((p1,p2) -> p1.getName().compareTo(p2.getName())).collect(Collectors.toList())) {
            System.out.println(person.getName());
        }
    }
    public boolean namePartOfGroup(String name){
        for(Person person : members){
            if(person.getName().equals(name))
                return true;

        }
        return false;
    }
}
