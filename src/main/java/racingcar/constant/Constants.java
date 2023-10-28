package racingcar.constant;

public final class Constants {
    public static final String ERROR_INVALID_REPEAT_COUNT = "[ERROR] 잘못된 반복 횟수를 입력하셨습니다. ";
    public static final String ERROR_INVALID_CAR_NAME = "[ERROR] 잘못된 유저 이름을 입력하셨습니다.";


    public static final int NAMES_MAX_LENGTH = 5;
    public static final int MIN_REPEAT_CNT = 0;
    public static final int MAX_REPEAT_CNT = Integer.MAX_VALUE;
    public static final int MOVE_RULE = 4;

    public static final String INPUT_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_REPEAT_COUNT = "시도할 회수는 몇회인가요?";
    public static final String INPUT_SPLIT_STRING = ",";

    public static final String OUTPUT_CAR_SCORE = "%s : %s \n";
    public static final String OUTPUT_SCORE_STRING = "-";
    public static final String OUTPUT_FINAL_WINNER = "최종 우승자 : %s";
    public static final String OUTPUT_FINAL_WINNER_SPLITTER = ", ";
}
