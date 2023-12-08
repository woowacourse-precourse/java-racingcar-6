package racingcar.type;

public enum PlayType {
    MAX_LENGTH(1),
    MIN_LENGTH(5),
    MAX_NUM(9),
    MIN_NUM(0),
    MOVING_POSSIBILITY(4),
    MIN_PARTICIPANT(1);

    private final int playValue;

    PlayType(int playValue) { this.playValue = playValue; }

    public int getPlayValue() { return playValue; }
}
