package racingcar;

public class RacingCarStatus {
    private static final String DELIMITER = " : ";
    private static final String POSITION_CHAR = "-";

    private final String name;
    private final int position;

    private RacingCarStatus(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static RacingCarStatus of(String name, int position) {
        return new RacingCarStatus(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String toString() {
        return String.join(DELIMITER, name, POSITION_CHAR.repeat(position));
    }
}
