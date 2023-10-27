package racingcar.validation;

import java.util.LinkedHashMap;
import java.util.Map;

public class InputValidation {
    private static final String IS_NULL_CAR_NAME_ERROR_MESSAGE = "입력하지 않았습니다.";
    private static final String IS_NOT_RANGE_NAME_ERROR_MESSAGE = "5자리 이하가 아닙니다.";

    public static Map<String, Integer> checkedInputValidation(String carNames){
        isNullCarName(carNames);
        return collectCarNames(carNames);
    }

    public static void isNullCarName(String carNames){
        if(carNames.isBlank()){
            throw new IllegalArgumentException(IS_NULL_CAR_NAME_ERROR_MESSAGE);
        }
    }

    public static Map<String, Integer> collectCarNames(String carNames){
        Map<String, Integer> collectCarName = new LinkedHashMap<>();
        String[] cars = carNames.split(",");
        for (String carName : cars) {
            isCheckedNameRange(carName);
            collectCarName.put(carName,0);
        }
        return collectCarName;
    }

    public static void isCheckedNameRange(String carName){
        if(carName.length()>5){
            throw new IllegalArgumentException(IS_NOT_RANGE_NAME_ERROR_MESSAGE);
        }
    }
}
