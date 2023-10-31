package racingcar.type;

public enum PlayType {
    MAX_NUM(9),
    MIN_NUM(0);

    private final int playValue;

    PlayType(int playValue) { this.playValue = playValue; }

    public int getPlayValue() { return playValue; }
}
