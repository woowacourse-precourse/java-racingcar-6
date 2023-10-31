package racingcar;

public class RacingCarGame {
    public void startGame() {
        InputView inputView = new InputView();
        inputView.pirntStartMsg();

        inputView.printCarNameInputMsg();

        inputView.printTryCountInputMsg();
    }
}
