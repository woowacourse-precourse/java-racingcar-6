package racingcar.domain;

public class Name {
    private static final int NAME_THRESHOLD = 5;

    private String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNameLength(name);
        validateCarNameEmpty(name);
    }

    private void validateNameLength(String carName) {
        if (isNameTooLong(carName)) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다");
        }
    }

    private void validateCarNameEmpty(String carName) {
        if (isNullOrBlank(carName)) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다");
        }
    }

    private boolean isNameTooLong(String carName) {
        return carName.length() > NAME_THRESHOLD;
    }

    private boolean isNullOrBlank(String carName) {
        return carName == null || carName.trim().isEmpty();
    }

    @Override
    public String toString() {
        return name;
    }
}
