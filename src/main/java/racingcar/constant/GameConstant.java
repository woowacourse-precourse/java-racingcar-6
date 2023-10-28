package racingcar.constant;

public enum GameConstant {
    MAX_CAR_NAME_LENGTH(5);

    private final int gameConstant;

    GameConstant(int gameConstant) {
        this.gameConstant = gameConstant;
    }

    public int getValue() {
        return gameConstant;
    }
}
