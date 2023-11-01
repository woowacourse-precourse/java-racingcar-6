package racingcar.validator;

import racingcar.system.SystemConstant;

import static racingcar.system.SystemMessage.*;

import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    public void validateRepeatTimesInput(String repeatTimesInput) {
        int repeatTimes = Integer.parseInt(repeatTimesInput);
        validateIsInputInteger(repeatTimesInput);
        validateIsNumberPositive(repeatTimes);
    }

    private void validateIsInputInteger(String repeatTimesInput) {
        try {
            Integer.parseInt(repeatTimesInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_POSITIVE_INTEGER_ONLY.getMessage());
        }
    }

    private void validateIsNumberPositive(int repeatTimes) {
        if (repeatTimes < 0) {
            throw new IllegalArgumentException(INPUT_POSITIVE_INTEGER_ONLY.getMessage());
        }
    }
}
