package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.dto.CarsDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private RacingGame() {
    }

    public static void run() {
        String carNames = inputView.enterCarNames();
        Cars cars = Cars.from(carNames);

        Integer numberOfTimes = convertToInteger(inputView.enterNumberOfTimes());

        rotate(cars, numberOfTimes);

        List<String> winners = cars.findWinnerNameList();

        outputView.printWinners(winners);
    }

    private static void rotate(Cars cars, Integer numberOfTimes) {
        outputView.printRunResult();

        while (numberOfTimes-- > 0) {
            cars.go();
            CarsDto carsDto = CarsDto.of(cars);

            outputView.printCarsResults(carsDto);
        }
    }

    private static Integer convertToInteger(String inputNumberString) {
        validateNumber(inputNumberString);

        return Integer.valueOf(inputNumberString);
    }

    private static void validateNumber(String inputNumberString) {
        if (isNotNumber(inputNumberString)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }

    }

    private static boolean isNotNumber(String inputNumberString) {
        final String REGEX = "[0-9]+";

        return !inputNumberString.matches(REGEX);
    }
}
