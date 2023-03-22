package splitter.Objects;
import java.util.ArrayList;
import java.util.List;
public class Persons {

    List<Person> persons;
    static Persons instance;

    private Persons() {
        persons = new ArrayList<>();
    }

    public static Persons getInstance() {
        if(instance == null){
            instance = new Persons();

        }
        return instance;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void removePerson(Person person) {
        persons.remove(person);
    }

    public boolean nameExists(String name){
        return persons.stream().anyMatch(person -> person.getName().equals(name));
    }

    public Person getWithName(String name){
        for(int index =0 ; index<persons.size(); index++){
            if(persons.get(index).name.equals(name))
                return persons.get(index);
        }
        return null;
    }

}
