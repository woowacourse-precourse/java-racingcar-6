package racingcar.view;

public class ConsoleOutputView implements OutputView{
    private static ConsoleOutputView instance;

    private ConsoleOutputView() {}

    public static ConsoleOutputView getInstance() {
        if (instance == null) {
            instance = new ConsoleOutputView();
        }
        return instance;
    }

    @Override
    public void printRequestCarNames() {

    }

    @Override
    public void printRequestGameRound() {

    }

    @Override
    public void printRoundResult() {

    }

    @Override
    public void printGameWinner() {

    }
}
