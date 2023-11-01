package racingcar;

import java.util.regex.Pattern;

public class Constants {
    public static final int NAME_SIZE = 5;
    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;
    public static final int GO_NUM = 4;

    public static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static final String DELIMITER = ",";
    public static final String ROUND_RESULT_DELIMETER = " : ";
    public static final String SCORE = "-";

    public static final Pattern CAR_NAMES_PATTERN = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + DELIMITER + "]*[가-힣\\w]$");
    public static final Pattern TRY_COUNT_PATTERN = Pattern.compile("^[1-9][0-9]*$");

    public static final String ERROR = "ERROR: ";
    public static final String CAR_NAME_SIZE_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
    public static final String CAR_NAME_WRONG_ERROR_MESSAGE = "자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능합니다.";
    public static final String INPUT_WRONG_ERROR_MESSAGE = "입력값이 존재하지 않습니다.";
    public static final String INPUT_ONLY_INTEGER_ERROR_MESSAGE = "숫자만 입력 가능합니다.";

    public static final String ROUND_RESULT = "실행 결과";
    public static final String WINNER_MESSAGE = "최종 우승자";
}
