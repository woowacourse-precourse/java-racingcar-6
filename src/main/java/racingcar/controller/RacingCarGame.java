package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private int number;

    private CarController carController;

    public void start() {
        String carNames = InputView.readCarNames();
        carController = new CarController(carNames);

        number = toInt(InputView.readNumber());

        OutputView.printBlankLine();
        run();
    }

    private void run() {
        OutputView.printGameResult();

        for (int i = 0; i < number; i++) {
            carController.move();
            OutputView.printBlankLine();
        }

        exist();
    }

    private void exist() {
        OutputView.printGameWinner(carController.getWinner());
    }

    int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 이외의 값을 입력했습니다.");
        }
    }
}
