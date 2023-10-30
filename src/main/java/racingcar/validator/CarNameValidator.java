package racingcar.validator;

import java.util.List;

public class CarNameValidator {
    private final List<String> carNames;
    public CarNameValidator(List<String> carNameList) {
        this.carNames = carNameList;
        validate();
    }

    public void validate() {
        isNameTooLong();
    }
    public void isNameTooLong() {
        if(carNames.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }


}
