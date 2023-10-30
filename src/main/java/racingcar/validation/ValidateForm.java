package racingcar.validation;

import racingcar.property.ValidateType;

import static racingcar.validation.NameValidation.*;
import static racingcar.validation.ScoreValidation.*;

public class ValidateForm {

    public static void validateForValidateType(ValidateType validateType,String inputValue){
        if (validateType == ValidateType.NAME){
            verifyForRacerName(inputValue);
            return;
        }

        if (validateType == ValidateType.NAME_LIST){
            verifyForRacerNameList(inputValue);
            return;
        }

        verifyForTargetScore(inputValue);
    }

    private static void verifyForRacerName(String inputValue){
        verifyForEmptyValue(inputValue);
        verifyForSpaceValue(inputValue);
        verifyForRacerNameIsLengthNotOver(inputValue);
        verifyForRacerNameIsEngOrKor(inputValue);
    }

    private static void verifyForRacerNameList(String racerNameList){
        verifyForRacerNameIsDuplicate(racerNameList);
    }

    private static void verifyForTargetScore(String targetScore){
        verifyForEmptyValue(targetScore);
        verifyForSpaceValue(targetScore);
        verifyForScoreIsNumericValue(targetScore);
        verifyForScoreIsOverStandard(targetScore);
    }
}
