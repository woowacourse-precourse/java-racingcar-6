package racingcar.view.constants;

public enum Numbers {
    MAX_NAME_LENGTH(5),
    MAX_GAME_PLAYER(100),
    MAX_GAME_PLAY(10000);

    private final int number;

    Numbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}