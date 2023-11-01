package racingcar.global;

public enum GameStrConstant {
    CAR_NAME_SEPARATOR(","),
    CAR_MOVEMENT("-"),
    GAME_RESULT_SEPARATOR(" : "),
    SPACE(" ");
    private final String value;

    GameStrConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
