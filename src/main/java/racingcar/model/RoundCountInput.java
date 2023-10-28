package racingcar.model;

/**
 * CarInput 클래스는 몇번 반복할지에 대한 입력을 파싱하고 검사한다.
 *
 * @author haiseong
 */
public class RoundCountInput {
    private static final int MINIMUM_ROUND_COUNT = 1;
    private static final String FORMAT_ERROR = "차수의 형식이 이상합니다.";
    private static final String MINIMUM_ROUND_COUNT_ERROR = "차수는 0보다 큰 수여야 합니다.";

    private final int roundCount;

    /**
     * @param userInput 사용자가 입력한 String 입력값
     */
    public RoundCountInput(String userInput) {
        this.roundCount = parseRoundCount(userInput);
        validate();
    }

    /**
     * 차수를 파싱한다.
     *
     * @param userInput 사용자가 입력한 String 입력값
     * @return 파싱한 차수
     */
    private int parseRoundCount(String userInput) {
        try {
            int roundCount = Integer.parseInt(userInput);
            return roundCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(FORMAT_ERROR);
        }
    }

    /**
     * 차수을 검사한다.
     */
    private void validate() {
        if (roundCount < MINIMUM_ROUND_COUNT) {
            throw new IllegalArgumentException(MINIMUM_ROUND_COUNT_ERROR);
        }
    }

    /**
     * 파싱한 차수를 제공한다.
     *
     * @return 파싱된 차수
     */
    public int getRoundCount() {
        return roundCount;
    }
}
