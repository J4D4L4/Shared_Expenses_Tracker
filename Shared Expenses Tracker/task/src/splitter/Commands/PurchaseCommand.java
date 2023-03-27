package splitter.Commands;

public class PurchaseCommand extends Command{
    protected PurchaseCommand( ) {
        super("purchase");
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean correctInput(String input) {
        String[] inputArray = input.split(" ");
        return false;
    }
}
