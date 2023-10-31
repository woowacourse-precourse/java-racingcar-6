package racingcar.model;

public class Round {

    private static final int MAXIMUM_INTEGER_VALUE = 0x7fffffff;
    private static final int ZERO = 0;
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String ERROR_NO_ROUND = "라운드는 0회일 수 없습니다.";
    private static final String ERROR_NEGATIVE_ROUND = "라운드는 음수일 수 없습니다.";
    private static final String ERROR_INTEGER_OVERFLOW = "오버플로우가 발생했습니다.";

    private int round;

    public Round(int round) {
        validateNoRound(round);
        validateNegativeRound(round);
        validateIntegerOverflow(round);
        this.round = round;
    }

    private void validateNoRound(int round) {
        if (round == ZERO) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_NO_ROUND);
        }
    }

    private void validateNegativeRound(int round) {
        if (round < ZERO) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_NEGATIVE_ROUND);
        }
    }

    private void validateIntegerOverflow(int round) {
        if (round > MAXIMUM_INTEGER_VALUE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_INTEGER_OVERFLOW);
        }
    }

    public boolean hasNextRound() {
        return this.round != 0;
    }

    public void finishRound() {
        this.round--;
    }
}
