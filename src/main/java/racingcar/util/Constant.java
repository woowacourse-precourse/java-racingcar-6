package racingcar.util;

public class Constant {

    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_RACING_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String OUTPUT_ROUND_RESULT_MESSAGE = "\n실행 결과";
    public static final String OUTPUT_ROUND_RESULT_DELIMITER = " : ";
    public static final String OUTPUT_CAR_MOVE_MARK = "-";
    public static final String OUTPUT_WINNER_MESSAGE = "최종 우승자 : ";
    public static final String OUTPUT_CAR_NAME_DELIMITER = ", ";


    public static final int CAR_NAME_MAX_SIZE = 5;
    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;
    public static final int ROUND_MINIMUM_NUM = 1;
    public static final int MOVE_MINIMUM_NUM = 4;

    public static final String REGEXP_CAR_NAME = "^[0-9a-zA-Z가-힣,]*$";
    public static final String REGEXP_ROUND_NUM = "^[1-9]\\d*$";
    public static final String CAR_NAME_DELIMITER = ",";
    public static final String BLANK = "";
}
