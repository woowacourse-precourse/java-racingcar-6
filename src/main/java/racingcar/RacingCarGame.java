package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    public void start() {
        String carNames = InputView.readCarNames();
        int number = InputView.readNumber();

        run();
    }

    private void run() {
        // TODO: Car 생성

        OutputView.printGameResult();

        // TODO: Car 경주 실행

        exist();
    }

    private void exist() {
        OutputView.printGameWinner();
    }
}
