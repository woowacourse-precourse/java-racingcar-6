package racingcar.validation;

import racingcar.model.CarName;

public class NameValidator {

    private CarName carName;

    private NameValidator(CarName carName) {
        this.carName = carName;
    }

    public static CarName create(String carName) {
        return new CarName(carName);
    }

    public void validate() {
        isLengthLessThan5();
        isBlank();
    }

    private void isLengthLessThan5() {
        if (carName.toString().length() >= 5) {
            throw new IllegalArgumentException("이름은 5자 이내여야 합니다.");
        }
    }

    public void isBlank() {
        if (carName.toString().isBlank()) {
            throw new IllegalArgumentException("이름에 빈 값이 들어올 수 없습니다.");
        }
    }
}
