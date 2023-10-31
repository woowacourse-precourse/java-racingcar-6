package racingcar.validator;

import racingcar.exception.ErrorMessage;
import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]*");

    private InputValidator() { }

    public static void validateName(String[] carNames) {
        for(String name : carNames){
            if (!NAME_PATTERN.matcher(name).matches()) {
                throw ErrorMessage.INVALID_NAME.getNameException();
            }
        }
    }

}