package splitter;

import splitter.Commands.Command;
import splitter.Commands.Commands;

import java.security.PublicKey;
import java.util.Scanner;

public class CommandLineInterface {


    public void run(){

        initialize();
        while (true) {
            interpretCommand();
        }

    }
    public void initialize(){

    }

    public String getUserInput(){
        boolean isCommand = false;
        String input ="";
        while (!isCommand) {
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            isCommand = isCommand(input);
            if(isCommand)
                break;
            System.out.println("Unknown command. Print help to show commands list");
        }

        return input;
    }

    public void interpretCommand() {
        String input = getUserInput();
        for(Commands commands : Commands.values()){
            if(input.contains(commands.command.inputString)){
                executeCommand(commands.command,input);
            }
        }

    }

    public boolean isCommand(String input) {
        for(Commands commands : Commands.values()){
            if(input.contains(commands.command.inputString)){
                return true;
            }
        }
        return false;

    }

    public void executeCommand(Command command, String input){
        if(command.correctInput(input)){
            command.execute();
        }
        else
            System.out.println("Illegal command arguments");
    }

}
