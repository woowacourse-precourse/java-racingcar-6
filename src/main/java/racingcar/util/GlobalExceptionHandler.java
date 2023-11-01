package racingcar.util;

import racingcar.domain.RacingCarConst;

public class GlobalExceptionHandler implements RacingCarConst {

    public boolean isValidCarArray(String carArray) {
        if (!",".contains(carArray)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isValidCarName(String carName) {
        if (carName.length()>CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isValidRacingCount(String racingCount) {
        try {
            Integer.parseInt(racingCount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
