package splitter.Commands;

public class ExitCommand extends Command{
    protected ExitCommand( ) {
        super("exit");
    }

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public boolean correctInput(String input) {
        String[] inputArray = input.split(" ");
        if (inputArray.length == 1)
            return true;
        else return false;
    }
}
