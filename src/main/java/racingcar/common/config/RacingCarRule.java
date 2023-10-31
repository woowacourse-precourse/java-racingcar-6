package racingcar.common.config;

public class RacingCarRule {
    public static final int MAX_RACER_NAME_LENGTH = 5;
    public static final int MAX_RACER_SIZE = 100;
    public static final int MAX_TOTAL_TURN = 9999;
    public static final String DELIMITER = ",";
    // 경주할 자동차 이름의 최대 길이, 경주할 자동차의 최대 개수, 구분자 길이를 기반으로 경주할 자동차 이름 입력값의 최대 길이를 계산
    public static final int MAX_RACER_NAME_INPUT_LENGTH =
            MAX_RACER_SIZE * MAX_RACER_NAME_LENGTH + DELIMITER.length() * (MAX_RACER_SIZE - 1);
    public static final int TOTAL_TURN_INPUT_LENGTH = String.valueOf(MAX_TOTAL_TURN).length();

    private RacingCarRule() {
    }
}
