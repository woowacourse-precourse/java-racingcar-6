package racingcar.domain;

public class Car {

    private static final int NAME_MAX_LENGTH = 5;

    private final String name;
    private int moving;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.moving = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoving() {
        return moving;
    }

    public void updateMovingCount() {
        this.moving++;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.isBlank() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("잘못된 이름을 입력하셨습니다.");
        }
    }
}
