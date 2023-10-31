package racingcar.domain;


import static racingcar.util.MagicNumber.MAX_NAME_LENGTH;
import static racingcar.util.MagicNumber.MIN_NAME_LENGTH;

public class Name {

    private final String name;

    public Name(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        validateCarNameEmptyOrNull(name);
        validateCarNameLength(name);
    }

    public void validateCarNameEmptyOrNull(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있으면 안됩니다.");
        }
    }

    public void validateCarNameLength(String carName) {
        if (name.length() < MIN_NAME_LENGTH.getNumber() || name.length() > MAX_NAME_LENGTH.getNumber()) {
            throw new IllegalArgumentException("자동차 이름의 길이는 1에서 5 사이여야 합니다.");
        }
    }

    public String getValue() {
        return this.name;
    }
}
