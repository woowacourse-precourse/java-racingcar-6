package racingcar.service;

public class CarNameCheck {

    public void isNothing(String carName) {
        if (carName.length() == 0) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    public void isIncludeBlank(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함됩니다.");
        }
    }

    public void isOverFive(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void checkAll(String carName) {
        isNothing(carName);
        isIncludeBlank(carName);
        isOverFive(carName);
    }
}
