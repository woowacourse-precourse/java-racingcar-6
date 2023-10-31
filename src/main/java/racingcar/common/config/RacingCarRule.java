package racingcar.common.config;

public class RacingCarRule {
    public static final int MAX_RACING_CAR_NAME_LENGTH = 5;
    public static final int MAX_RACING_CAR_SIZE = 100;
    public static final int MAX_TURN_COUNT = 9999;
    public static final String INPUT_DELIMITER = ",";
    // 경주할 자동차 이름의 최대 길이, 경주할 자동차의 최대 개수, 구분자 길이를 기반으로 경주할 자동차 이름 입력값의 최대 길이를 계산
    public static final int MAX_RACING_CAR_NAME_INPUT_LENGTH =
            MAX_RACING_CAR_SIZE * MAX_RACING_CAR_NAME_LENGTH + INPUT_DELIMITER.length() * (MAX_RACING_CAR_SIZE - 1);
    public static final int TOTAL_TURN_INPUT_LENGTH = String.valueOf(MAX_TURN_COUNT).length();

    private RacingCarRule() {
    }
}
