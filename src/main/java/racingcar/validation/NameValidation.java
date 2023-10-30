package racingcar.validation;

import racingcar.property.ErrorProperty;
import racingcar.property.ValidateProperty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NameValidation extends InputValidation{

    public static void verifyForRacerNameIsEngOrKor(String racerName){
        System.out.println("Race"+racerName);
        if (!racerName.matches("^[a-zA-Z가-힣]*$")){
            throw new IllegalArgumentException(ErrorProperty.NAME_VALUE_IS_NOT_CORRECT_FORM);
        }
    }

    public static void verifyForRacerNameIsLengthNotOver(String racerName){
        if (racerName.length()> ValidateProperty.NAME_LENGTH_STANDARD){
            throw new IllegalArgumentException(ErrorProperty.NAME_VALUE_LENGTH_IS_OVER);
        }
    }

    public static void verifyForRacerNameIsDuplicate(String racerNameList){
        List<String> nameList = Arrays.asList(racerNameList.split(","));
        if (nameList.size() != new HashSet<>(nameList).size()){
            throw new IllegalArgumentException(ErrorProperty.NAME_VALUE_IS_DUPLICATE);
        }
    }
}
