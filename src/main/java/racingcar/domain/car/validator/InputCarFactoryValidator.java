package racingcar.domain.car.validator;

import java.util.Arrays;
import racingcar.domain.car.carfactory.CarFactory;

public class InputCarFactoryValidator {

    public void validateCarNames(String[] carNames) {
        validateDuplicateNames(carNames);
        validateCarNamesLength(carNames);
    }

    private void validateDuplicateNames(String[] carNames) {
        if (uniqueNameCount(carNames) != carNames.length) {
            throw new IllegalArgumentException("자동차 이름에 중복이 있습니다.");
        }
    }
    private long uniqueNameCount(String[] carNames) {
        return Arrays.stream(carNames)
                .map(String::trim)
                .distinct()
                .count();
    }

    private void validateCarNamesLength(String[] carNames) {
        if(carNames.length > CarFactory.MAX_CAR_SIZE) {
            throw new IllegalArgumentException("자동차는 최대 " + CarFactory.MAX_CAR_SIZE + "대 만들 수 있습니다.");
        }
    }
}
