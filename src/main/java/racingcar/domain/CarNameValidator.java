package racingcar.domain;

public class CarNameValidator {

    private final String carName;

    public CarNameValidator(String carName) {
        this.carName = carName;
        validateCarNameExists();
    }

    public void validateCarNameExists() {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }

}
