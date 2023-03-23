package splitter.Commands;

public enum Commands {

    BALANCE(new BalanceCommand()) ,
    BORROW(new BorrowCommand()),
    EXIT(new ExitCommand()),
    HELP(new HelpCommand()),
    REPAY(new RepayCommand());

    public Command command;
    Commands(Command command){
        this.command=command;
    }


}
