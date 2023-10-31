package racingcar.input;

import static racingcar.util.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleInput implements Input{

    private static final String NUMBER_REGEX = "^[1-9][0-9]*$";
    private static final String CAR_NAME_SPLIT_PREFIX = ",";

    @Override
    public List<String> inputRacingCarNames() {
        String racingCarNamesInput = Console.readLine();
        List<String> carNames = Arrays.stream(racingCarNamesInput.split(CAR_NAME_SPLIT_PREFIX))
                .map(String::trim)
                .toList();

        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
        return carNames;
    }

    @Override
    public int inputMovementForwardCount() {
        String movementForwardCountInput = Console.readLine();
        validateIsNumber(movementForwardCountInput);
        return Integer.parseInt(movementForwardCountInput);
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ILLEGAL_CAR_NAME_LENGTH);
        }
    }

    private void validateIsNumber(String movementForwardCountInput) {
        if (!movementForwardCountInput.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(NON_NUMBER);
        }
    }
}
