package splitter.Objects;

import java.util.UUID;

public class Person {
    String id;
    String name;

    public Person(String name){

        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
