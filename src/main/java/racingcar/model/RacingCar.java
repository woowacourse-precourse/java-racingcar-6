package racingcar.model;

public class RacingCar {
    private static final int FORWARD_THRESHOLD = 4;
    private static final int NAME_LIMIT = 5;
    private static final String WRONG_NAME_LENGTH = "이름은 5자 이하만 입력됩니다.";
    private final String name;
    private int position;

    public RacingCar(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    private void validate(String name) {
        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException(WRONG_NAME_LENGTH);
        }
    }

    public boolean move(int speed) {
        if (speed >= FORWARD_THRESHOLD) {
            this.position += speed;
            return true;
        }
        return false;
    }
}
