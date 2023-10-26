package racingcar.controller;

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

        //cars.findWinners();
    }

    private static void rotate(Cars cars, Integer numberOfTimes) {
        while (numberOfTimes-- > 0) {
            cars.go();
            CarsDto carsDto = CarsDto.of(cars);
            outputView.printCarsResults(carsDto);
        }
    }

    private static Integer convertToInteger(final String inputNumberString) {
        validateNumber(inputNumberString);

        return Integer.valueOf(inputNumberString);
    }

    private static void validateNumber(final String inputNumberString) {
        if (isNotNumber(inputNumberString)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }

    }

    private static boolean isNotNumber(final String inputNumberString) {
        final String REGEX = "[0-9]+";

        return !inputNumberString.matches(REGEX);
    }
}
