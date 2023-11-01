package racingcar.domain;

import racingcar.domain.view.InputView;
import racingcar.domain.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private static final String NOT_VALID_ATTEMPT_COUNT_FORMAT_ERROR_MESSAGE = "시도 횟수는 1이상값만 가능합니다.";
    private static final String NOT_VALID_ATTEMPT_COUNT_RANGE_ERROR_MESSAGE = "시도 횟수는 숫자값만 가능합니다.";

    public void start() {
        Cars cars = initCarNames();
        int attemptCount = initAttemptNumber();

        race(cars, attemptCount);

        judge(cars);
    }

    private Cars initCarNames() {
        return new Cars(InputView.inputCarNameList());
    }

    private int initAttemptNumber() {

        int attemptNumber = isNumber();

        if (attemptNumber < 1) {
            throw new IllegalArgumentException(NOT_VALID_ATTEMPT_COUNT_RANGE_ERROR_MESSAGE);
        }
        return attemptNumber;
    }

    private static int isNumber() {
        try {
            return Integer.parseInt(InputView.inputAttemptNumber());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_VALID_ATTEMPT_COUNT_FORMAT_ERROR_MESSAGE);
        }
    }

    private void race(Cars cars, int attemptNumber) {
        OutputView.showStartRace();

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        while (attemptNumber-- > 0) {
            List<Integer> randomNumbers = randomNumberGenerator.generate(cars.getCars().size());
            cars.goOrStop(randomNumbers);
            OutputView.showRaceProgress(cars.getCars());
        }
    }

    private void judge(Cars cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = -1;

        for (Car car : cars.getCars()) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }

        for (Car car : cars.getCars()) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        OutputView.showWinner(winners);
    }
}
