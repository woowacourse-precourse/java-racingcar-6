package racingcar.assist;

import static racingcar.system.SystemMessage.*;

import java.util.List;

public class InputValidator {

    public void validateCarNamesInput(List<String> carNameList){
        for (String carName : carNameList) {
            validateCarNameOutOfRange(carName);
        }
    }


    private void validateCarNameOutOfRange(String carName){
        if(carName.length() > 5){
            throw new IllegalArgumentException(INPUT_OUT_OF_RANGE.getMessage());
        }
    }
}
