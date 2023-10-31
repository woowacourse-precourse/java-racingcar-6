package racingcar.validation;

import racingcar.property.ErrorProperty;

public abstract class InputValidation {
    public static void verifyForEmptyValue(String inputValue){
        if (inputValue.equals("")){
            throw new IllegalArgumentException(ErrorProperty.VALUE_IS_EMPTY);
        }
    }

    public static void verifyForSpaceValue(String inputValue){
        String eliminateSpaceValue = inputValue.replaceAll(" ", "");
        if (!inputValue.equals(eliminateSpaceValue)){
            throw new IllegalArgumentException(ErrorProperty.VALUE_CONTAINS_SPACE);
        }
    }
}
