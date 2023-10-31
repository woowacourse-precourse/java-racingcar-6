package racingcar.domain;

import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputRaceCount;

import java.util.List;
import racingcar.common.exception.CustomErrorException;
import racingcar.common.response.ErrorCode;

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
            cars.racing();
        }
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
