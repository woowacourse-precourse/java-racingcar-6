package racingcar.validation;

import static racingcar.utils.Utils.replaceCommaToBlank;

public final class Validation {

    public static void validateIsNotNull(String inputString){
        if (inputString == null
                || replaceCommaToBlank(inputString).isBlank()) {
            throw new IllegalArgumentException();
        }
    }

}
