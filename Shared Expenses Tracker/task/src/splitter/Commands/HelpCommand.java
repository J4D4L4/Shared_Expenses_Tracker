package splitter.Commands;

public class HelpCommand extends Command{
    protected HelpCommand() {
        super("help");
    }

    @Override
    public void execute() {

        for(Commands command : Commands.values()){
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
