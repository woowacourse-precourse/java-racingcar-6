package racingcar.exception;

public class RacingCarGameRepositoryException extends IllegalArgumentException {

    public static final String NOT_FOUND = "자동차 경주게임이 존재하지 않습니다.";

    public RacingCarGameRepositoryException(String s) {
        super(s);
    }

}
