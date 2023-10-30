package racingcar.model;

import racingcar.enums.ErrorMessage;
import racingcar.enums.GameConstant;
import racingcar.enums.OutputMessage;

public class Name {
    private String name;

    public Name(String name) {
        validateLengthOfName(name);
        this.name = name;
    }

    private void validateLengthOfName(String name) {
        Integer maximumLength = GameConstant.MAXIMUM_LENGTH_OF_CAR_NAME.getContentToInteger();

        if (name.isEmpty() || name.length() > maximumLength) {
            String errorMessage = ErrorMessage.LENGTH_OF_NAME_RANGE.getMessage();

            throw new IllegalArgumentException(errorMessage);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
