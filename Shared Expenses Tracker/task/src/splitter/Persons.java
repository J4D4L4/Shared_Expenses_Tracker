package splitter;
import java.util.ArrayList;
import java.util.List;
public class Persons {

    List<Person> persons;
    Persons instance;

    public Persons getInstance() {
        if(instance == null){
            instance = new Persons();
            instance.persons = new ArrayList<>();
        }
        return instance;
    }
}
