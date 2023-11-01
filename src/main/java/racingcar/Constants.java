package racingcar;

import java.util.regex.Pattern;

public class Constants {

    // 숫자
    public static final int MAX_NUM = 9;
    public static final int MIN_NUM = 0;
    public static final int BASELINE_NUM = 4; // +1 되는 기준이 되는 숫자
    public static final int NAME_SIZE = 5;

    // 문자
    public static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String REQUEST_NUMBER_OF_ROUNDS = "시도할 회수는 몇회인가요?";
    public static final String DELIMITER = ",";
    public static final String DELIMITER_WINNER = ", ";
    public static final String ROUND_RESULT = "\n실행 결과";
    public static final String ROUND_RESULT_DELIMITER = " : ";
    public static final String FINAL_WINNER = "최종 우승자 : ";
    public static final String DASH = "-";

    // 형식 검사
    public static final Pattern nameStringPattern = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + DELIMITER + "]*[가-힣\\w]$"); // 한국어 문자, 알파벳, 밑줄, 숫자로 이루어져있는지 확인
    public static final Pattern roundNumPattern = Pattern.compile("^[1-9][0-9]*$"); // 양의 정수를 나타내는 문자열 확인

    // ERROR Messages
    public static final String ERROR = "[ERROR] ";
    public static final String CAR_NAME_WRONG_ERROR = ERROR + "자동차 목록은 쉼표로 구분된 비어있지 않은 문자여야 합니다";
    public static final String CAR_NAME_SIZE_ERROR = ERROR + "자동차 목록의 이름은 1~5자의 문자로 구성되어야 합니다";
    public static final String CAR_NAME_DUPLICATED_ERROR = ERROR + "자동차 목록에 중복된 이름이 있습니다";
    public static final String ROUND_NUM_WRONG_ERROR = ERROR + "시도 횟수는 1이상의 숫자여야 합니다";

}
