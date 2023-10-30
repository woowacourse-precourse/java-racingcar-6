package racingcar.validator;

import static racingcar.model.ControlValue.MAX_LEN_OF_CAR_NAME;
import static racingcar.model.ControlValue.MIN_NUM_OF_CAR;
import static racingcar.validator.ErrorMessage.EXCEED_MAX_LEN_OF_CAR_NAME;
import static racingcar.validator.ErrorMessage.LESS_THAN_MIN_NUM_OF_CAR;

public class InputValidator {
    // carList 관련 유효성 검사
    public static void validateCarList(String carListString) {
        String[] carList = carListString.split(",");
        validateLenOfCar(carList);
        for (String car : carList) {
            validateLenOfCarName(car);
        }
    }

    private static void validateLenOfCar(String[] carList) {
        if (carList.length < MIN_NUM_OF_CAR.getValue()) {
            throw new IllegalArgumentException(LESS_THAN_MIN_NUM_OF_CAR.getMessage());
        }
    }

    private static void validateLenOfCarName(String car) {
        if (car.length() > MAX_LEN_OF_CAR_NAME.getValue()) {
            throw new IllegalArgumentException(EXCEED_MAX_LEN_OF_CAR_NAME.getMessage());
        }
    }

    // 경기 횟수 관련 유효성 검사
    
}
