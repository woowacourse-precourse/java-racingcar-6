package racingcar.assist;

import static racingcar.system.SystemMessage.*;

import java.util.List;

public class InputValidator {

    public void validateCarNamesInput(List<String> carNameList){
        for (String carName : carNameList) {
            validateCarNameOutOfRange(carName);
        }
    }

    public void validateRepeatTimesInput(String repeatTimesInput) {
        int repeatTimes = validateIsInputInteger(repeatTimesInput);
        validateIsNumberPositive(repeatTimes);
    }


    private void validateCarNameOutOfRange(String carName){
        if(carName.length() > 5){
            throw new IllegalArgumentException(INPUT_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateIsNumberPositive(int repeatTimes){
        if (repeatTimes < 0 ){
            throw new IllegalArgumentException(INPUT_POSITIVE_INTEGER_ONLY.getMessage());
        }
    }

    private int validateIsInputInteger(String repeatTimesInput){
        try {
            return Integer.parseInt(repeatTimesInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(INPUT_POSITIVE_INTEGER_ONLY.getMessage());
        }
    }

}
