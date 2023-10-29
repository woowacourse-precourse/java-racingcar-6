package racingcar.domain;

import racingcar.domain.view.InputView;

public class RacingCarGame {

    public void start() {
        Cars cars = initCarNames();
        int attemptCount = initAttemptNumber();
    }

    private Cars initCarNames() {
        return new Cars(InputView.inputCarNameList());
    }

    private int initAttemptNumber() {
        try {
            return Integer.parseInt(InputView.inputAttemptNumber());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수만 입력 가능합니다.");
        }
    }


}
