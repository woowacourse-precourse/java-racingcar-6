package racingcar.validation;

import java.util.LinkedHashMap;
import java.util.Map;

public class InputValidation {
    private static final String IS_NULL_CAR_NAME_ERROR_MESSAGE = "입력하지 않았습니다.";

    public static Map<String, Integer> checkedInputValidation(String carNames){
        isNullCarName(carNames);
        return changeCarName();
    }

    public static void isNullCarName(String carNames){
        if(carNames.isBlank()){
            throw new IllegalArgumentException(IS_NULL_CAR_NAME_ERROR_MESSAGE);
        }
    }
}
