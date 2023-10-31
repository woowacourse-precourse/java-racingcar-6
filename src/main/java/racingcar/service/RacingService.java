package racingcar.service;

import static racingcar.domain.enums.Constants.MIN_RACING_COUNT;
import static racingcar.domain.enums.Error.INVALID_MIN_RACE_COUNT;
import static racingcar.domain.enums.Error.INVALID_NUMBER_FOMMAT;

import racingcar.domain.Cars;
import racingcar.util.ErrorException;

public class RacingService {

    private Cars cars;
    private int racingCount;

    public RacingService(Cars cars, String racingCount) {
        this.cars = cars;
        this.racingCount = validateNumber(racingCount);
        validateMinRacingCount(this.racingCount);
    }

    public void playRacing() {
        cars.moveCars();
        racingCount--;
    }

    public boolean isPlayRacing() {
        return racingCount >= MIN_RACING_COUNT;
    }

    public Cars getCars() {
        return cars;
    }

    private void validateMinRacingCount(int racingCount) {
        if (racingCount < MIN_RACING_COUNT) {
            throw new ErrorException(INVALID_MIN_RACE_COUNT);
        }
    }

    private int validateNumber(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new ErrorException(INVALID_NUMBER_FOMMAT);
        }
    }
}