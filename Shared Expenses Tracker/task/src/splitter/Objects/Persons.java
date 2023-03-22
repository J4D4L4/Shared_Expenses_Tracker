package splitter.Objects;
import splitter.Builder.BillDirector;
import splitter.Builder.ConcreteBillBuilder;

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

    public Person getOrCreatePerson(String name){

        if(nameExists(name)){
            return getWithName(name);
        }
        else
            return createPerson(name);
    }

    private Person createPerson(String name){
        Person neuePerson = new Person(name);
        persons.add(neuePerson);
        return neuePerson;
    }

    public List<Person[]> getPersonPairs(){
        List<Person[]> personPairs = new ArrayList<>();
        for(int index =0 ; index<persons.size(); index++){
            for(int secondIndex = index+1; secondIndex< persons.size(); secondIndex++){
                Person[] personArray = {persons.get(index), persons.get(secondIndex)};
                personPairs.add(personArray);
            }
        }
        return  personPairs;
    }

}
