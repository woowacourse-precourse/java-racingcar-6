package racingcar;

import racingcar.view.InputView;

public class RacingCarGame {
    public void start() {
        String carNames = InputView.readCarNames();
        int number = InputView.readNumber();

        run();
    }

    private void run() {
        // TODO: Car 생성

        System.out.println("\n" + Constants.OUTPUT_GAME_RESULT);

        // TODO: Car 경주 실행

        exist();
    }

    private void exist() {
        System.out.print(Constants.OUTPUT_GAME_WINNER);
    }
}
