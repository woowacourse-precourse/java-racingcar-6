package racingcar.domain;

public class CarName {
    private final String name;

    public CarName(String carName) {
        this.name = carName;
        validateCarName();
    }

    public String getName() {
        return name;
    }

    private void validateCarName() {
        isCarNameLength();
        isCommaPresent();
    }

    private void isCarNameLength() {
        if (name.length() >= 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로만 입력해주세요.");
        }
    }

    private void isCommaPresent() {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백을 제외해주세요.");
        }
    }
}
