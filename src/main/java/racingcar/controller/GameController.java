package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class GameController {
    public void playGame() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<String> racingCarNames = splitRacingCarNames(inputView.inputRacingCarNames());
        validateRacingCarNames(racingCarNames);

        int movingNumber = convertMovingNumberToInteger(inputView.inputMovingNumber());
        validateMovingNumber(movingNumber);
    }

    static public List<String> splitRacingCarNames(String racingCarNames) {
        return Arrays.asList(racingCarNames.split(","));
    }

    static public void validateRacingCarNames(final List<String> racingCarNames) {
        if (racingCarNames.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (String racingCarName : racingCarNames) {
            if (racingCarName.isEmpty()) {
                throw new IllegalArgumentException();
            } else if (racingCarName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
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
