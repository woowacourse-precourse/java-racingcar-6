package racingcar.entity;

import racingcar.property.ValidateType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static racingcar.property.ValidateType.*;
import static racingcar.validation.ValidateForm.validateForValidateType;

public class RacerName {
    private static String racerNameList;

    public RacerName(String inputRacerNameList){
        racerNameList=inputRacerNameList;
    }

    public void validateRacerName(){
        validateForValidateType(NAME_LIST,racerNameList);
        Arrays.stream(racerNameList.split(","))
                            .forEach(racerName->
                                    validateForValidateType(NAME,racerName)
                            );
    }
}
