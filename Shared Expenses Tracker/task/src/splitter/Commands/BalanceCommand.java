package splitter.Commands;

public class BalanceCommand extends Command{
    protected BalanceCommand() {
        super("balance");
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean correctInput(String input) {
        return false;
    }
}
