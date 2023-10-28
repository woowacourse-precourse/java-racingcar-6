package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    private final InputValidator inputValidator;
    private static final String DEFAULT_CAR_NAMES_INPUT = "";

    public InputUtil() {
        inputValidator = new InputValidator();
    }

    public String inputCarName() {
        String carInput = Console.readLine();
        if (inputValidator.isValidCarNameInput(carInput)) {
            return carInput;
        }
        return DEFAULT_CAR_NAMES_INPUT;
    }

}
