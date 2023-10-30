package racingcar;

public class Car {
    private static final int MAX_LENGTH = 5;
    private static final int INIT_PROGRESS_VALUE = 0;

    private final String name;
    private int progress;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.progress = INIT_PROGRESS_VALUE;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH) throw new IllegalArgumentException("[ERROR] 이름은 5글자를 넘을 수 없습니다.");
    }

}
