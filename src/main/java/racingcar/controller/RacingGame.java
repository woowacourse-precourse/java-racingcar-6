package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.dto.CarsDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private static final Integer ZERO = 0;
    private static final String REGEX = "[0-9]+";

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private Integer rotateCount;
    private Cars cars;

    public RacingGame() {
    }

    public void run() {
        init();

        rotate();

        finish();
    }

    private void init() {
        cars = generateCars();
        rotateCount = askRotateNumber();
    }

    private Cars generateCars() {
        String carNames = inputView.enterCarNames();

        return Cars.from(carNames);
    }

    private Integer askRotateNumber() {
        String rotateNumber = inputView.enterRotateNumber();
        
        return convertToInteger(rotateNumber);
    }

    private Integer convertToInteger(String inputNumberString) {
        validateNumber(inputNumberString);

        return Integer.valueOf(inputNumberString);
    }

    private void validateNumber(String inputNumberString) {
        if (isNotNumber(inputNumberString)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }

    }

    private boolean isNotNumber(String inputNumberString) {
        return !inputNumberString.matches(REGEX);
    }

    private void rotate() {
        outputView.printRunResult();

        while (isRemainRotateCount()) {
            raceStart();
            subRotateCount();
        }
    }

    private void subRotateCount() {
        rotateCount--;
    }

    private boolean isRemainRotateCount() {
        return rotateCount > ZERO;
    }

    private void raceStart() {
        cars.go();
        CarsDto carsDto = CarsDto.of(cars);

        outputView.printCarsResults(carsDto);
    }

    private void finish() {
        List<String> winners = cars.findWinnerNameList();

        outputView.printWinners(winners);
    }
}
