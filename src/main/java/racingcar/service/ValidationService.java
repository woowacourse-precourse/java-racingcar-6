package racingcar.service;

import racingcar.exception.RacingCarException;

import java.util.Arrays;
import java.util.List;

import static racingcar.constants.Delimiters.CAR_NAME_DELIMITER;
import static racingcar.constants.ErrorMessage.INVALID_CAR_NAME_LENGTH_ERROR;
import static racingcar.constants.ErrorMessage.INVALID_CAR_RANGE_ERROR;
import static racingcar.constants.RacingCarConstants.*;

public class ValidationService {

    public List<String> validateCarsRange(String cars) {
        List<String> carNames = splitByDelimiter(cars);

        if (carNames.size() < CAR_MIN.getValue() || carNames.size() > CAR_MAX.getValue()) {
            throw new RacingCarException(INVALID_CAR_RANGE_ERROR);
        }

        return carNames;
    }

    private List<String> splitByDelimiter(String input) {
        return Arrays.asList(input.split(CAR_NAME_DELIMITER.getMessage()));
    }

    public void validateCarsName(List<String> names) {

        names.forEach(name -> {
            if (name.length() > NAME_MAX_LENGTH.getValue()) {
                throw new RacingCarException(INVALID_CAR_NAME_LENGTH_ERROR);
            }
        });

    }

}