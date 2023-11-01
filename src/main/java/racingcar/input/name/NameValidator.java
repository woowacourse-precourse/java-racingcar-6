package racingcar.input.name;

import racingcar.constant.ErrorMessage;

public class NameValidator {
    public static void isValid(String name) {
        if(!(NameLengthValidator.hasValidLength(name) && NameCharacterValidator.hasValidCharacters(name))) {
            throw new IllegalArgumentException(ErrorMessage.getErrorMessage("name"));
        }
    }
}
