package racingcar.view.constants;

public enum Numbers {
    MAX_NAME_LENGTH(5),
    MIN_GAME_PLAYER(2),
    MAX_GAME_PLAYER(100),
    MAX_GAME_PLAY(1000);

    private final int number;

    Numbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}