package racingcar.model;

import java.util.regex.Matcher;
import racingcar.enums.ErrorMessage;
import racingcar.enums.GameConstant;
import racingcar.enums.OutputMessage;

public class Name {
    private String name;

    public Name(String name) {
        name = name.strip();
        validateNamePattern(name);
        validateLengthOfName(name);
        this.name = name;
    }

    private void validateNamePattern(String name) {
        Matcher nameMatcher = GameConstant.NAME_PATTERN.matcher(name);

        if (nameMatcher.matches() == false) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_PATTERN_OF_NAME.getMessage());
        }
    }

    private void validateLengthOfName(String name) {
        Integer maximumLength = GameConstant.MAXIMUM_LENGTH_OF_CAR_NAME.getContentToInteger();

        if (name.length() > maximumLength) {
            String errorMessage = ErrorMessage.LENGTH_OF_NAME_RANGE.getMessage();

            throw new IllegalArgumentException(errorMessage);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
