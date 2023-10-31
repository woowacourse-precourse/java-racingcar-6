package racingcar.service;

public class CarNameCheck {

    public static void isNothing(String carName) {
        if (carName.length() == 0) {
            throw new IllegalArgumentException("입력값이 없습니다. 자동차 이름을 입력해주세요.");
        }
    }

    public static void isIncludeBlank(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함됩니다. 자동차 이름은 쉼표(,)로 구분되오니 공백 없이 올바르게 입력해주세요.");
        }
    }

    public static void isOverFive(String carName) {
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
