package racingcar.utils;

import java.util.List;
import racingcar.constants.ErrorMessage;

public class Validator {
    public static void validateCarName(List<String> names) {
        int len = names.stream().filter(name -> name.length() > 5).toList().size();
        if(len > 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_MUST_BE_5_CHARACTERS_LESS.getMessage());
        }
    }
}
