package splitter.Commands;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HelpCommand extends Command{
    protected HelpCommand() {
        super("help");
    }

    @Override
    public void execute() {

        for(Commands command : Arrays.stream(Commands.values()).sorted((s1, s2) -> s1.name().compareTo(s2.name())).collect(Collectors.toList())){
            System.out.println(command.name().toLowerCase());
        }

    }

    @Override
    public boolean correctInput(String input) {
        String[] inputArray = input.split(" ");
        if (inputArray.length == 1)
            return true;
        else return false;
    }
}
