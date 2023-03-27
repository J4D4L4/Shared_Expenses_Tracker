package splitter.Commands;

import splitter.Objects.Group;
import splitter.Objects.Groups;
import splitter.Objects.Person;
import splitter.Objects.Persons;
import splitter.RegExHelper;

import java.util.List;
import java.util.ArrayList;

public class GroupCommand extends Command{
    String option;
    Persons persons;
    Groups groups;
    protected GroupCommand( ) {
        super("group");
        persons = Persons.getInstance();
        groups = Groups.getInstance();
    }

    @Override
    public void execute() {
        if (option.equals("create")){
            createGroup(this.userInput);
        }
        if (option.equals("show")){
            Group group = groups.getByName(this.userInput[2]);
            group.print();
        }


    }

    @Override
    public boolean correctInput(String input) {
        String[] inputArray = input.split(" ");
        if(trySetOption(inputArray)){
            if(option.equals("show") && checkInputShow(inputArray)){
                return true;
            }
            if(option.equals("create" ) && checkInputCreate(inputArray)){
                return true;
            }
        }
        return false;
    }

    boolean trySetOption(String[] input){

        if(input[1].equals("create")
                || input[1].equals("show")){
            this.option = input[1];
            return true;
        }
        return false;
    }

    boolean checkLengthCreate(String[] input){
        if(input.length >= 4)
            return true;
        else return false;
    }

    boolean checkLengthShow(String[] input){
        if(input.length == 3)
            return true;
        else return false;
    }

    Group createGroup( String[] input){
        Group group = new Group(input[2]);
        for(int counter = 3; counter< input.length; counter++){
            String personName = input[counter].replace("(","")
                    .replace(")","")
                    .replace(",","");
            group.addPerson(persons.getOrCreatePerson(personName));
        }
        groups.addGroup(group);
        return group;
    }
    boolean checkInputCreate(String[] input){
        if(checkLengthCreate(input)
                && RegExHelper.isUpperCase(input[2]))
            return true;
        else
            return false;
    }

    boolean checkInputShow(String[] input){
        if(checkLengthShow(input)
                && RegExHelper.isUpperCase(input[2] )
                && groups.getByName(input[2]) != null)
            return true;
        else
            return false;
    }

}
