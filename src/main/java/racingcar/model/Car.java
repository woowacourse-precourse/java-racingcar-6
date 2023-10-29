package racingcar.model;

public class Car {
    private static final int NAME_LENGTH = 5;
    public String name;
    public int moveCount = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        checkNameLength(name);
        checkNameIsEmpty(name);
    }

    private static void checkNameLength(String name) {
        if (name.length() > NAME_LENGTH)
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    private static void checkNameIsEmpty(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }
}
