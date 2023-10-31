package racingcar.domain;

import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputRaceCount;
import static racingcar.view.OutputView.printNewLine;
import static racingcar.view.OutputView.printSituation;

import java.util.List;
import racingcar.common.exception.CustomErrorException;
import racingcar.common.response.ErrorCode;
import racingcar.dto.CarDto;
import racingcar.view.OutputView;

public class RacingGame {

    private static final String SEPARATOR = ",";

    private final Cars cars;
    private final RaceCount raceCount;

    public RacingGame() {
        this.cars = getCars();
        this.raceCount = getRaceCount();
    }

    public void run() {
        play();
        printWinning();
    }

    private void play() {
        for (int i = 0; i < raceCount.count(); i++) {
            racing();
        }
    }

    private void racing() {
        cars.racing();
        printRaceResult();
    }

    private void printRaceResult() {
        printNewLine();
        cars.getCars().forEach(car -> {
            CarDto dto = CarDto.of(car);
            printSituation(dto);
        });
    }

    private void printWinning() {
        List<String> carNames = getWinningCarNames();
        OutputView.printResult(carNames);
    }

    private List<String> getWinningCarNames() {
        return cars.winningCars().stream()
                .map(Car::getName)
                .toList();
    }

    private Cars getCars() {
        String input = inputCarNames();
        String[] carNames = input.split(SEPARATOR);
        return new Cars(List.of(carNames));
    }

    private RaceCount getRaceCount() {
        String input = inputRaceCount();
        try {
            int raceCount = Integer.parseInt(input);
            return new RaceCount(raceCount);
        } catch (NumberFormatException e) {
            throw new CustomErrorException(ErrorCode.NOT_NUMBER_STRING);
        }
    }
}
