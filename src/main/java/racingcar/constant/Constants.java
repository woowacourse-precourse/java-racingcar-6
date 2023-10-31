package racingcar.constant;

public class Constants {
    public static final char NAME_SEPARATOR = ',';
    public static final String NAME_SEPARATOR_STRING = ",";
    public static final String DOUBLE_USE_SEPARATOR = ",,";
    public static final String SEPARATE_NAME_TO_SCORE = " : ";
    public static final String SCORE = "-";
    public static final String WINNER_SEPARATOR = ", ";
    public static final char BLANK = ' ';

    public static final int START_RANDOM_NUMBER = 0;
    public static final int END_RANDOM_NUMBER = 9;
    public static final int FORWARD_CRITERIA = 4;
    public static final int NAME_MAX_LENGTH = 5;

    public static final String EXCEPTION_INT_RANGE = "가능한 최댓값을 초과하였습니다.";
    public static final String EXCEPTION_SAME_NAME = "중복된 이름이 존재합니다.";
    public static final String EXCEPTION_BLACK_INPUT = "빈칸이 입력되었습니다.";
    public static final String EXCEPTION_CHAR_INPUT = "문자를 입력하였습니다.";
    public static final String EXCEPTION_SEPARATOR_START = ",으로 시작할 수 없습니다.";
    public static final String EXCEPTION_SEPARATOR_END = ",으로 끝날 수 없습니다.";
    public static final String EXCEPTION_DOUBLE_USE_SEPARATOR = "쉼표를 연속으로 사용하였습니다.";
    public static final String EXCEPTION_NAME_LENGTH = "이름은 5자 이하만 가능합니다.";
    public static final String EXCEPTION_NAME_START_BLACK = "이름이 공백으로 시작하면 안됩니다.";
    public static final String EXCEPTION_NAME_END_BLACK = "이름이 공백으로 끝나면 안됩니다.";

    public static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ROUND_NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String START_ROUND_MESSAGE = "\n실행 결과";
    public static final String WINNER_MESSAGE_START = "최종 우승자 : ";

}