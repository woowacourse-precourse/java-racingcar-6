package racingcar.validation;

import java.util.List;

public class CommonValidator {

    public void isNull(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    public void isNullList(List<String> nameList) {
        if (nameList.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

}
