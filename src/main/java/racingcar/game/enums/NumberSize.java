package racingcar.game.enums;

public enum NumberSize {
    START_INCLUSIVE(0, "시작 숫자"),
    END_INCLUSIVE(9, "끝 숫자");

    private final int size;
    private final String description;

    NumberSize(int size, String description) {
        this.size = size;
        this.description = description;
    }

    public int getSize() {
        return this.size;
    }

    public String getDescription() {
        return description;
    }
}
