package racingcar;

public class RacingCarGame {
    public void startGame() {
        InputView inputView = new InputView();
        inputView.pirntStartMsg();

        User user = new User();

        inputView.printCarNameInputMsg();
        user.inputCarName();

        inputView.printTryCountInputMsg();
        user.inputTryCount();

    }
}
