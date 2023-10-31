package racingcar.entity;

import static racingcar.property.ValidateType.*;
import static racingcar.validation.ValidateForm.validateForValidateType;

public class RacerNameList {
    private static String racerNameList;

    public RacerNameList(String inputRacerNameList){
        racerNameList=inputRacerNameList;
    }

    public void validateRacerNameList(){
        validateForValidateType(NAME_LIST,racerNameList);
    }
}
