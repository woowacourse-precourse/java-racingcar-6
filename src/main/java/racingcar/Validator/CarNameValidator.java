package racingcar.Validator;

import static racingcar.Message.CarNameExceptionPrompt.LENGTHMESSAGE;
import static racingcar.Message.CarNameExceptionPrompt.WHITESPACEMESSAGE;
import static racingcar.Validator.CarNameValidationCriteria.MAX_LENGTH;
import static racingcar.Validator.CarNameValidationCriteria.MIN_LENGTH;

import java.util.List;
import racingcar.Exception.GameException.CarNameException;

public class CarNameValidator {
    public static void isValidLength(String carName) {
        Integer minLengthValue = (Integer) MIN_LENGTH.getValue();
        Integer maxLengthValue = (Integer) MAX_LENGTH.getValue();

        if (carName.length() <= minLengthValue || carName.length() >= maxLengthValue) {
            throw new CarNameException(LENGTHMESSAGE.getMessage(carName));
        }
    }

    public static void hasWhiteSpace(String carName) {
        if (carName.contains(INVALID_CHARACTER.getValue().toString())) {
            throw new CarNameException(WHITESPACEMESSAGE.getMessage(carName));
        }
    }

    public static void hasDuplicateName(List<String> carNames) {
    }
}
