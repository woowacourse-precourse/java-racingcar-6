package racingcar.util;

public class RacingCarVO {

    private static String START_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static String ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";
    private static String EXECUTION_RESULT = "실행 결과";
    private static String FINAL_WINNER = "최종 우승자 : ";
    private static int RANDOM_MIN_VALUE = 0;
    private static int RANDOM_MAX_VALUE = 9;
    private static int MOVE_THRESHOLD = 4;

    public static String getStartSentence() {
        return START_SENTENCE;
    }

    public static String getAttemptCount() {
        return ATTEMPT_COUNT;
    }

    public static String getExecutionResult() {
        return EXECUTION_RESULT;
    }

    public static String getFinalWinner() {
        return FINAL_WINNER;
    }

    public static int getRandomMinValue() {
        return RANDOM_MIN_VALUE;
    }

    public static int getRandomMaxValue() {
        return RANDOM_MAX_VALUE;
    }

    public static int getMoveThreshold() {
        return MOVE_THRESHOLD;
    }
}
