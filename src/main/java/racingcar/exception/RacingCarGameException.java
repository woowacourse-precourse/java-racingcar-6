package racingcar.exception;

public class RacingCarGameException extends RuntimeException {

    public static final String NON_NEGATIVE_GAME_COUNT_RESTRICTION = "게임 횟수는 0 이상이어야 합니다.";
    public static final String NOT_GAME_END_CONDITION_RESTRICTION = "게임 종료 조건이 아닙니다.";

    public RacingCarGameException(String message) {
        super(message);
    }
}
