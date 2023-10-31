package racingcar.entity;

import static racingcar.property.ValidateType.*;
import static racingcar.validation.ValidateForm.validateForValidateType;

public class RacerNames {
    private static String racerNames;

    public RacerNames(String inputRacerNameList){
        racerNames =inputRacerNameList;
    }

    public void validateRacerNameList(){
        validateForValidateType(NAME_LIST, racerNames);
    }
}
