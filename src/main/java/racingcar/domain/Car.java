package racingcar.domain;

public class Car {

    private static final Integer MAX_NAME_LENGTH = 5;

    private static final Integer INIT_POSITION = 0;
    private final MovingStrategy movingStrategy;

    private final String name;
    private int position;

    public Car(MovingStrategy movingStrategy, String name, int position) {
        validateNameLength(name);
        validateNameBlank(name);
        validateInitPosition(position);
        this.movingStrategy = movingStrategy;
        this.name = name;
        this.position = position;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 입력할 수 있는 이름의 글자수는 최대 5입니다.");
        }
    }

    private void validateNameBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백을 입력할 수 없습니다.");
        }
    }

    private void validateInitPosition(int position) {
        if (position != INIT_POSITION) {
            throw new IllegalArgumentException("[ERROR] 자동차의 시작 위치는 0입니다.");
        }
    }
}
