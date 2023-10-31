package racingcar.constant;

public enum StringConstant {

    GAME_PROCEED_CHAR("-")
    ,DIVISION_STANDARD(",");

    private final String message;

    StringConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
