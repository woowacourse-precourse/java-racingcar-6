package racingcar.game.constant;

public abstract class CarExceptionMessage {

    public static final String SHOULD_HAVE_VALUE = "자동차의 이름은 필수값입니다.";
    public static final String OUT_OF_LENGTH_RANGE = "자동차의 이름이 1~5자 사이가 아닙니다.";
    public static final String NOT_ALLOW_SIDE_BLANK= "자동차 이름의 양 끝에는 공백이 올 수 없습니다.";
    public static final String EXIST_SAME_NAMES= "모든 자동차 이름은 서로 달라야 합니다.";
    public static final String OUT_OF_COUNT_RANGE = "자동차 개수는 10 이하여야 합니다.";

}
