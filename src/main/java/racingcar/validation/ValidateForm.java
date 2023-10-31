package racingcar.validation;

import racingcar.property.ValidateType;

import static racingcar.validation.NameValidation.*;
import static racingcar.validation.CountValidation.*;

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

        verifyForRaceCount(inputValue);
    }

    private static void verifyForRacerName(String racerName){
        verifyForEmptyValue(racerName);
        verifyForSpaceValue(racerName);
        verifyForRacerNameIsLengthNotOver(racerName);
        verifyForRacerNameIsEngOrKor(racerName);
    }

    private static void verifyForRacerNameList(String racerNameList){
        verifyForRacerNameIsDuplicate(racerNameList);
        verifyForRacerNameContainComma(racerNameList);
    }

    private static void verifyForRaceCount(String raceCount){
        verifyForEmptyValue(raceCount);
        verifyForSpaceValue(raceCount);
        verifyForRaceCountIsNumericValue(raceCount);
        verifyForRaceCountIsOverStandard(raceCount);
    }
}
