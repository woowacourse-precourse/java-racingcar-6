package racingcar.validation;

public class Validator {

    public void valid(String carName) {
        checkCarNameLength(carName);
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 해주세요.");
        }
    }
}
