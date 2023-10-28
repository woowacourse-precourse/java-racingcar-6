package racingcar.validation;

import java.util.List;
import racingcar.domain.Car;

public class RacingCarValidation {
    public static final String CAR_LIST_IS_NOT_AVAIL = "최소 두 개 이상의 차 이름을 입력해주세요.";
    public static final String CAR_NAME_LENGTH_IS_NOT_AVAIL = "차 이름은 다섯글자로 입력해주세요";
    public static final int CAR_NAME_LIMIT_LENGTH = 5;

    public static void isNotAvailCarList(List<Car> carList) {
        int size = carList.size();
        if (size <= 1) {
            throw new IllegalArgumentException(CAR_LIST_IS_NOT_AVAIL);
        }
    }

    public static void isNotAvailCarName(List<Car> carList) {
        boolean invalidCarNameExists = carList.stream().anyMatch(car -> car.getName().length() > CAR_NAME_LIMIT_LENGTH);
        if (invalidCarNameExists) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_IS_NOT_AVAIL);
        }
    }
}
