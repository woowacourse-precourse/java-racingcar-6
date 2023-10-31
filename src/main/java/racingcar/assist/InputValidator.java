package racingcar.assist;

import racingcar.system.SystemConstant;

import static racingcar.system.SystemMessage.*;

import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    public void validateCarNamesInput(List<String> carNameList){
        for (String carName : carNameList) {
            validateCarNameOutOfRange(carName);
        }
        validateCarNameDuplicate(carNameList);
        validateIsCompetitorExist(carNameList);
    }

    private void validateIsCompetitorExist(List<String> carNameList) {
        if (carNameList.size() == 1){
            throw new IllegalArgumentException(COMPETITOR_NOT_EXIST.getMessage());
        }
    }

    private void validateCarNameDuplicate(List<String> carNameList) {
        long distinctCount = carNameList.stream().distinct().count();
        if(distinctCount != carNameList.size()){
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED.getMessage());
        }
    }

    public void validateRepeatTimesInput(String repeatTimesInput) {
        int repeatTimes = validateIsInputInteger(repeatTimesInput);
        validateIsNumberPositive(repeatTimes);
    }


    private void validateCarNameOutOfRange(String carName){
        if(carName.length() > SystemConstant.CAR_NAME_MAX_RANGE){
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
