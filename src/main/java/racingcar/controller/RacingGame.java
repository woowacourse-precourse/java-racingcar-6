package racingcar.controller;

import java.util.stream.IntStream;
import racingcar.constant.ErrorMessage;
import racingcar.domain.Cars;
import racingcar.exception.RacingCarException;
import racingcar.validator.InputNumberValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void start() {
        String userInput = InputView.requestUserInputNames();

        Cars cars = Cars.createCarList(userInput);

        String runningNumber = InputView.requestRunningCount();

        progressRound(cars, runningNumber);

        announceFinalResult(cars);
    }

    private void progressRound(Cars cars, String runningNumber) {
        try {
            Integer runningCount = parseInputToInt(runningNumber);

            InputNumberValidator.validateInputNumber(runningCount);

            OutputView.noticeRunningResult();

            IntStream.range(0, runningCount).forEach(i -> progressOneRound(cars));
        } catch (NumberFormatException e) {
            throw new RacingCarException(ErrorMessage.NON_NUMERIC_VALUE);
        }
    }

    private void progressOneRound(Cars cars) {
        cars.moveAllCars();
        OutputView.printCarStatus(cars.convertCarToMap());
    }

    private void announceFinalResult(Cars cars) {

        OutputView.noticeFinalWinner();
        OutputView.printWinnerNames(cars.findWinnerCars());
    }

    private Integer parseInputToInt(String userInputNumber) {
        return Integer.parseInt(userInputNumber);
    }
}
