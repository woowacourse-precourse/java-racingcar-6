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
        validateBlank();
        validateLength();
    }

    private void validateCarNames(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("사용자는 최대 2명 이상입니다.");
        }
    }

    private void validateLength() {
        if (carName.toString().length() >= 5) {
            throw new IllegalArgumentException("이름은 5자 이내여야 합니다.");
        }
    }

    public void validateBlank() {
        if (carName.toString().isBlank()){
            throw new IllegalArgumentException("이름에 빈 값이 들어올 수 없습니다.");
        }
    }
}
