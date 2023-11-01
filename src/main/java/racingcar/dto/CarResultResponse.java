package racingcar.dto;

public record CarResultResponse(String carName, int movingCount) {

    private static final String GAME_RESULT_MESSAGE_FORMAT = "%s : %s";
    private static final String MOVEMENT_SYMBOL = "-";

    @Override
    public String toString() {
        return String.format(GAME_RESULT_MESSAGE_FORMAT, carName, MOVEMENT_SYMBOL.repeat(movingCount));
    }
}
