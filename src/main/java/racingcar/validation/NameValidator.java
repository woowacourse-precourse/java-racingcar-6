package racingcar.validation;

import java.util.List;
import racingcar.model.vo.CarName;

public class NameValidator {

    public void validate(String carNameString) {
        hasComma(carNameString);
    }

    public void validate(List<CarName> carNames) {
        for (CarName carName : carNames) {
            isLengthLessThan5(carName);
            isBlank(carName);
        }
    }

    private void hasComma(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("사용자는 최대 2명 이상입니다.");
        }
    }

    private void isLengthLessThan5(CarName carName) {
        if (carName.toString().length() >= 5) {
            throw new IllegalArgumentException("이름은 5자 이내여야 합니다.");
        }
    }

    public void isBlank(CarName carName) {
        if (carName.toString().isBlank()) {
            throw new IllegalArgumentException("이름에 빈 값이 들어올 수 없습니다.");
        }
    }
}
