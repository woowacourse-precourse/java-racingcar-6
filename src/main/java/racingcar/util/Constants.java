package racingcar.util;

public class Constants {


    public static final String CAR_NAME_LONGER_THAN_5_EXCEPTION = "자동차 이름은 5자 이하만 가능하다.";
    public static final String LAP_NO_INTEGER_INPUT_EXCEPTION = "랭킹 수는 숫자만 입력 가능하다.";
    public static final String LAP_NOT_POSITIVE_INTEGER_EXCEPTION = "랭킹 수는 1 이상의 정수만 입력 가능하다.";

    public static final String INPUT_CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_RACE_LAP_PROMPT = "시도할 회수는 몇회인가요?";

    public static final int MOVEMENT_THRESHOLD = 4;
    public static final int RANDOM_RANGE_MIN = 0;
    public static final int RANDOM_RANGE_MAX = 9;


    public static final String CAR_MOVEMENT_INDICATOR = "-";
    public static final String COLON_SEPARATOR = ":";
    public static final String SPACE = " ";
    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";
    public static final String WINNER_PROMPT = "최종 우승자";

    private Constants() {
    }
}
