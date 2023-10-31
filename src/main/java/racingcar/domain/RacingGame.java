package racingcar.domain;

import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputRaceCount;
import static racingcar.view.OutputView.printSituation;

import java.util.List;
import racingcar.common.exception.CustomErrorException;
import racingcar.common.response.ErrorCode;
import racingcar.dto.CarDto;

public class RacingGame {

    private static final String SEPARATOR = ",";

    private final Cars cars;
    private final RaceCount raceCount;

    public RacingGame() {
        this.cars = getCars();
        this.raceCount = getRaceCount();
    }

    public void run() {
        for (int i = 0; i < raceCount.count(); i++) {
            racing();
        }
    }

    private void racing() {
        cars.racing();
        printRaceResult();
    }

    private void printRaceResult() {
        cars.getCars().forEach(car -> {
            CarDto dto = CarDto.of(car);
            printSituation(dto);
        });
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
