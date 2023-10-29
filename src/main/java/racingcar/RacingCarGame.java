package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private String carNames;
    private int number;

    private CarController carController;

    public void start() {
        carNames = InputView.readCarNames();
        number = InputView.readNumber();

        System.out.print("\n");
        run();
    }

    private void run() {
        carController = new CarController(carNames);

        OutputView.printGameResult();

        // TODO: Car 경주 실행

        exist();
    }

    private void exist() {
        OutputView.printGameWinner();
    }
}
