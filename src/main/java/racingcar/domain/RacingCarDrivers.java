package racingcar.domain;

import java.util.Arrays;
import racingcar.error.ErrorMessage;
import racingcar.error.RacingCarDrivers.NameLengthExceededException;

public class RacingCarDrivers {
    private static final String COMMAND = ",";
    private static final int LIMIT_SIZE = 5;

    private String[] racingCarDriversArray;

    public RacingCarDrivers(String racingCarDrivers) {
        validateRacingCarDrivers(racingCarDrivers);
    }

    private void validateRacingCarDrivers(String racingCarDrivers) {
        racingCarDriversArray = Arrays.stream(racingCarDrivers.split(COMMAND))
            .map(String::trim)
            .peek(this::validateDriverNameSize)
            .toArray(String[]::new);
    }

    private void validateDriverNameSize(String driver) {
        if (LIMIT_SIZE < driver.length()) {
            throw new NameLengthExceededException(ErrorMessage.NAME_LENGTH_EXCEEDED_EXCEPTION);
        }
    }

    public String[] getRacingCarDriversArray() {
        return racingCarDriversArray;
    }
}