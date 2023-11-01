package racingcar.validator;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.DeduplicationUtils;

public class CarInputValidator {

    private static final int CAR_NAME_MAX_SIZE = 5;
    private static final int CAR_NAME_NULL_SIZE = 0;

    private CarInputValidator() {
    }

    public static void nameLengthValidate(String name) {
        if (name.length() > CAR_NAME_MAX_SIZE) {
            throw new IllegalArgumentException(CAR_NAME_MAX_SIZE + "글자 이하의 글자를 입력하셔야 합니다.");
        }
    }

    public static void nameNullValidate(String name) {
        if (name.length() == CAR_NAME_NULL_SIZE) {
            throw new IllegalArgumentException("자동차 이름을 입력하지 않으셨습니다.");
        }
    }

    public static void duplicateNameValidate(List<Car> carList) {
        int carListSize = carList.size();
        carList = DeduplicationUtils.deduplication(carList, Car::getName);
        if(carListSize != carList.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }
}
