package racingcar;

public class RacingCarController {
    public void run() {
        OutputView.printStart();
        gameStart();
    }

    private void gameStart() {
        InputView.inputCarNames();
    }
}
