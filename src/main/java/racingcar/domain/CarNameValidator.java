package racingcar.domain;

public class CarNameValidator {

    private final String carName;

    public CarNameValidator(String carName) {
        this.carName = carName;
        validateCarNameExists();
        validateAlphanumericAndCommaCarName();
    }

    public void validateCarNameExists() {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }

    public void validateAlphanumericAndCommaCarName() {
        if (!carName.matches("[a-zA-Z0-9,]+")) {
            throw new IllegalArgumentException("자동차 이름은 영숫자와 콤마로만 구성되어야 합니다.");
        }
    }

}
