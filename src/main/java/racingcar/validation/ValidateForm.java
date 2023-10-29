package racingcar.validation;

import static racingcar.validation.NameValidation.*;

public class ValidateForm {

    public static void verifyForRacerName(String inputValue){
        verifyForEmptyValue(inputValue);
        verifyForSpaceValue(inputValue);
        verifyForRacerNameIsLengthNotOver(inputValue);
        verifyForRacerNameIsEngOrKor(inputValue);
    }

    public static void verifyForRacerNameList(String racerNameList){

    }
}
