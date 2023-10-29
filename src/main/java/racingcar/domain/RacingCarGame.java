package racingcar.domain;

import racingcar.domain.view.InputView;
import racingcar.domain.view.OutputView;

import java.util.List;

public class RacingCarGame {

    public void start() {
        Cars cars = initCarNames();
        int attemptCount = initAttemptNumber();
        race(cars, attemptCount);
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

    private void race(Cars cars, int attemptNumber) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        while (attemptNumber-- > 0) {
            List<Integer> randomNumbers = randomNumberGenerator.generate(cars.getCars().size());
            cars.goOrStop(randomNumbers);
            OutputView.outputRaceProgress(cars.getCars());
        }
    }
}
