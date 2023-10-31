package racingcar.domain;

public class Car {
    private static final int START_POSITION = 0;
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        isValid(name);
        this.name = name;
        this.position = START_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void isValid(String name) {
        checkNull(name);
        checkBlank(name);
        checkNameLength(name);
        checkNameFormat(name);
    }

    private void checkNull(String name) {
        if (name == null) {
            throw new NullPointerException("자동차 이름 null 불가");
        }
    }

    private void checkBlank(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 공백 불가");
        }
    }

    private void checkNameLength(String name) {
        if (name.trim().length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름 글자 범위 초과");
        }
    }

    private void checkNameFormat(String name) {
        if (!name.matches("^[a-zA-Z0-9]+$")) {
            throw new IllegalArgumentException("자동차 이름은 문자와 숫자만 가능");
        }
    }
}
