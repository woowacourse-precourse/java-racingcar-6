package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.constant.ErrorMessage;
import racingcar.constant.InputConstant;
import racingcar.validation.Validation;

public class InputView {
    private static final Validation validation = new Validation();

    public List<String> getCarNames() {
        try {
            String carNames = Console.readLine();

            validation.validateCarNames(carNames);

            return Arrays.stream(carNames.split(InputConstant.DELIMITER.getValue())).toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_INPUT_EXCEPTION.getMessage());
        }
    }

    public int getMovementTime() {
        try {
            String movementTime = Console.readLine();

            validation.validateMovementTime(movementTime);

            return Integer.parseInt(movementTime);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.MOVEMENT_TIME_INPUT_EXCEPTION.getMessage());
        }
    }
}
