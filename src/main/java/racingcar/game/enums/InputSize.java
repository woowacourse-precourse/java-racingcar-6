package racingcar.game.enums;

public enum InputSize {
    START_INCLUSIVE(0),
    END_INCLUSIVE(9),
    MAX_SIZE(5);

    private final int size;

    InputSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

}
