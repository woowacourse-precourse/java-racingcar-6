package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void playGame() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RacingCars racingCars = RacingCars.createRacingCars(inputView.inputRacingCarNames());

        int movingNumber = convertMovingNumberToInteger(inputView.inputMovingNumber());
        validateMovingNumber(movingNumber);
    }

    static public int convertMovingNumberToInteger(final String movingNumber) {
        try {
            return Integer.parseInt(movingNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("정수가 아닌 값을 입력했습니다.");
        }
    }

    static public void validateMovingNumber(final int movingNumber) {
        if (movingNumber <= 0) {
            throw new IllegalArgumentException("양수가 아닌 값을 입력했습니다.");
        }
    }
}
