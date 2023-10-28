package racingcar.validator;

import racingcar.domain.Car;

import java.util.HashSet;
import java.util.List;

public class CarValidator {

    private static final int CHECK_IF_TRY_COUNT_LESS_THAN_ZERO = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String STRING_REGEX = "^[\\w]*$";
    private static final String CAR_NAME_LENGTH_ERROR = "자동차의 이름은 1글자 이상 5글자 이하여야 합니다.";
    private static final String CAR_NAME_TYPE_ERROR = "자동차의 이름은 공백 없는 문자열이어야 합니다.";
    private static final String TRY_COUNT_ERROR = "시도 횟수는 0회 이상이어야 합니다.";
    private static final String DUPLICATE_CAR_NAME_ERROR = "자동차의 이름은 중복될 수 없습니다.";

    public static void checkAllException(List<Car> carList){
        for(Car carName : carList){
            checkCarNameLength(carName.getCarName());
            checkCarNameType(carName.getCarName());
            checkDuplicateCarName(carList);
        }
    }

    public static void checkDuplicateCarName(List<Car> carList) {
        HashSet<Car> carHashSet = new HashSet<>(carList);
        if(carHashSet.size() != carList.size()){
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR);
        }
    }

    public static void checkCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH || carName.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
    }

    public static void checkCarNameType(String carName) {
        if (!carName.matches(STRING_REGEX)) {
            throw new IllegalArgumentException(CAR_NAME_TYPE_ERROR);
        }
    }

    public static void checkTryCount(int tryCount) {
        if (tryCount < CHECK_IF_TRY_COUNT_LESS_THAN_ZERO) {
            throw new IllegalArgumentException(TRY_COUNT_ERROR);
        }
    }
}
