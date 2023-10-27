package racingcar.converter;

import racingcar.domain.game.Cars;
import racingcar.util.InputValidator;

public class InputConverter {
    private final InputValidator inputValidator;

    public InputConverter(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public Cars convertStringToCars(String input) {
        inputValidator.validatePlayerNamesFormat(input);
        inputValidator.validateNonEmpty(input);
        return Cars.of(input);
    }

    public int covertStringToInteger(String input) {
        inputValidator.validateNumericString(input);
        return Integer.parseInt(input);
    }
}
