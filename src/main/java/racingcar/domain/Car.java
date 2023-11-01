package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int POSITION_INIT_VALUE = 0;
    private static final int MOVE_CONDITION = 4;
    private static final int POSITION_INCREMENT_VALUE = 1;

    private final String name;
    private int position;

    public Car(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "글자 이하여야 합니다.");
        }
        this.name = name;
        this.position = POSITION_INIT_VALUE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            position += POSITION_INCREMENT_VALUE;
        }
    }
}