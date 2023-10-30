package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private String carNames;
    private int number;

    private CarController carController;

    public void start() {
        carNames = InputView.readCarNames();
        number = toInt(InputView.readNumber());

        OutputView.printBlankLine();
        run();
    }

    private void run() {
        carController = new CarController(carNames);

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

    private int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 이외의 값을 입력했습니다.");
        }
    }
}
