package racingcar.controller;

public class RoundCountHandler implements UserInputHandler<Integer> {
    int roundCount;

    @Override
    public void handle(String stringRoundCount) {
        try {
            roundCount = Integer.parseInt(stringRoundCount);
            isZero(roundCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_MESSAGE);
        }
    }

    private void isZero(int roundCount) {
        if (roundCount == 0) {
            throw new IllegalArgumentException(ErrorMessage.ZERO_ERROR_MESSAGE);
        }
    }

    @Override
    public Integer getHandledResult() {
        return roundCount;
    }
}
