package racingcar.util;

public class Constants {
    /** Validation **/
    public static final String INVALID_CAR_NAMES_EMPTY = "자동차 이름을 입력해주세요.";
    public static final String INVALID_CAR_NAMES_DUPLICATE = "중복된 자동차 이름이 존재합니다.";
    public static final String INVALID_CAR_NAMES_LENGTH = "자동차 이름은 5자 이하만 가능합니다.";
    public static final String INVALID_ROUND_EMPTY = "시도할 회수를 입력해주세요.";
    public static final String INVALID_ROUND_ONE_OR_MORE = "시도할 회수는 1 이상의 숫자만 가능합니다.";
    public static final String REGEX_NUMBER = "[0-9]+";
    public static final String INVALID_MOVE_STRATEGY_NULL = "움직임 전략이 null입니다.";

    /** Input, Output **/
    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String RACING_RESULT_MESSAGE = "\n실행 결과";
    public static final String RACING_WINNER_MESSAGE = "최종 우승자 : %s\n";
    public static final String PROGRESS_MESSAGE = "%s : %s\n";
    public static final String PROGRESS_DELIMITER = "-";
    public static final String CAR_NAME_DELIMITER = ",";
}
