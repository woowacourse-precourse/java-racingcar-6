package racingcar.domain;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        checkBlank(name);
        checkLength(name);
        checkNumeric(name);
    }

    private void checkBlank(String name) {
        if (name.equals(" ")) {
            throw new IllegalArgumentException("공백은 입력 불가능 합니다.");
        }
    }

    private void checkLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5자 이하의 이름만 가능합니다.");
        }
    }

    private void checkNumeric(String name) {
        if (name.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("숫자는 입력 불가능 합니다.");
        }
    }
}
