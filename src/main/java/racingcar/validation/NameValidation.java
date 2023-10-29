package racingcar.validation;

import racingcar.property.ErrorProperty;

public class NameValidation extends InputValidation{

    public static void verifyForRacerNameIsEngOrKor(String inputValue){
        if (!inputValue.equals("^[a-zA-Z가-힣]*$")){
            throw new IllegalArgumentException(ErrorProperty.NAME_VALUE_IS_NOT_CORRECT_FORM);
        }
    }
}
