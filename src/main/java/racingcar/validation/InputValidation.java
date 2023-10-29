package racingcar.validation;

import java.util.LinkedHashMap;
import java.util.Map;

public class InputValidation {
    private static final String IS_NULL_CAR_NAME_ERROR_MESSAGE = "입력하지 않았습니다.";
    private static final String IS_NOT_RANGE_NAME_ERROR_MESSAGE = "5자리 이하가 아닙니다.";

    public String[] checkedInputValidation(String carNames){
        isNullText(carNames);
        return collectCarNames(carNames);
    }

    private void isNullText(String carNames){
        if(carNames.isBlank()){
            throw new IllegalArgumentException(IS_NULL_CAR_NAME_ERROR_MESSAGE);
        }
    }

    private String[] collectCarNames(String carNames){
        String[] cars = carNames.split(",");
        for (String carName : cars) {
            isCheckedNameRange(carName);
        }
        return cars;
    }

    private void isCheckedNameRange(String carName){
        if(carName.length()>5){
            throw new IllegalArgumentException(IS_NOT_RANGE_NAME_ERROR_MESSAGE);
        }
    }
}
