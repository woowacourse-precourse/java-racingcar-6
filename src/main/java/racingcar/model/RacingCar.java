package racingcar.model;

public class RacingCar {

    private static final int FORWARD_THRESHOLD = 4;
    private static final int NAME_LIMIT = 5;
    private static final String WRONG_NAME_LENGTH = "이름은 5자 이하만 입력됩니다.";
    private static final String POSITION_SIGN = "-";
    private static final String COLON = " : ";
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

    public void move(int speed) {
        if (speed >= FORWARD_THRESHOLD) {
            this.position++;
        }
    }

    public RaceStatus compare(RacingCar nominee) {
        return nominee.compare(this.position);
    }

    private RaceStatus compare(int position) {
        if (this.position < position) {
            return RaceStatus.WIN;
        }

        if (this.position > position) {
            return RaceStatus.LOSE;
        }

        return RaceStatus.DRAW;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + COLON + position();
    }

    private String position() {
        return POSITION_SIGN.repeat(this.position);
    }
}
