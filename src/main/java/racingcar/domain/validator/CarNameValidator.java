package racingcar.domain.validator;

import java.util.List;

public class CarNameValidator {

    private final List<String> carNames;

    public CarNameValidator(String carName) {
        this.carNames = List.of(carName.split(","));
        validateCarNameExists();
        validateAlphanumericAndCommaCarName();
        validateCarNameLength();
        validateCarNameDuplicate();
    }

    private void validateCarNameExists() {
        if (carNames.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }

    private void validateAlphanumericAndCommaCarName() {
        if (carNames.stream().anyMatch(name -> !name.matches("[a-zA-Z0-9,]+"))) {
            throw new IllegalArgumentException("자동차 이름은 영숫자와 콤마로만 구성되어야 합니다.");
        }
    }

    private void validateCarNameLength() {
        if (carNames.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
    }

    private void validateCarNameDuplicate() {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

}
