package racingcar.domain;

import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputRaceCount;
import static racingcar.view.OutputView.printCarStatus;
import static racingcar.view.OutputView.printNewLine;
import static racingcar.view.OutputView.printResult;

import java.util.List;
import racingcar.common.exception.CustomErrorException;
import racingcar.common.response.ErrorCode;
import racingcar.dto.CarInfo;

public class RacingGame {

    private static final String SEPARATOR = ",";

    private final Cars cars;
    private final RaceCount raceCount;

    public RacingGame() {
        this.cars = createCars();
        this.raceCount = createRaceCount();
    }

    public void run() {
        playGame();
        printWinningCars();
    }

    private void playGame() {
        while (!raceCount.isEnd()) {
            raceCount.reduceCount();
            cars.racing();
            printCarsStatus();
        }
    }

    private void printCarsStatus() {
        printNewLine();
        cars.getCars().forEach(car -> {
            CarInfo carInfo = CarInfo.of(car);
            printCarStatus(carInfo);
        });
    }

    private void printWinningCars() {
        List<String> winningCarNames = getWinningCarNames();
        printResult(winningCarNames);
    }

    private List<String> getWinningCarNames() {
        return cars.winningCars().stream()
                .map(Car::getName)
                .toList();
    }

    private Cars createCars() {
        String input = inputCarNames();
        String[] carNames = input.split(SEPARATOR);
        List<String> carNameList = List.of(carNames);
        return new Cars(carNameList);
    }

    private RaceCount createRaceCount() {
        String input = inputRaceCount();
        try {
            int raceCount = Integer.parseInt(input);
            return new RaceCount(raceCount);
        } catch (NumberFormatException e) {
            throw new CustomErrorException(ErrorCode.NOT_NUMBER_STRING);
        }
    }
}
