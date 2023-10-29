package racingcar.validation;

import racingcar.property.ErrorProperty;
import racingcar.property.ValidateProperty;

public class NameValidation extends InputValidation{

    public static void verifyForRacerNameIsEngOrKor(String inputValue){
        if (!inputValue.equals("^[a-zA-Z가-힣]*$")){
            throw new IllegalArgumentException(ErrorProperty.NAME_VALUE_IS_NOT_CORRECT_FORM);
        }
    }

    public static void verifyForRacerNameIsLengthNotOver(String inputValue){
        if (inputValue.length()> ValidateProperty.NAME_LENGTH_STANDARD){
            throw new IllegalArgumentException(ErrorProperty.NAME_VALUE_LENGTH_IS_OVER);
        }
    }
}
