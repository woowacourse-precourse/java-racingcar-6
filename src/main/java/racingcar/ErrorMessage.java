package racingcar;

public class ErrorMessage {
    public static final String RACE_COUNT_IS_NOT_NUMBER = "[ERROR] 시도 횟수는 숫자로 입력해야 합니다.";
    public static final String RACE_COUNT_IS_NOT_IN_RANGE = "[ERROR] 0보다 큰 숫자를 입력해야합니다.";

    public static final String PLAYER_NAME_LENGTH_IS_INVALID = "[ERROR] 이름은 5자 이하로 입력해야 합니다.";
    public static final String PLAYER_NAMES_IS_INVALID_FORMAT = "[ERROR] ,로 구분되게 입력되어야 합니다.";


    private ErrorMessage() {
    }
}
