package racingcar.util;

public class RoundCountValidator {

    private final String roundCount;

    public RoundCountValidator(String roundCount) {
        this.roundCount = roundCount;
        roundCountValidate();
    }

    private void roundCountValidate() {
        if (!isDigit() || !isMinRoundCount())
            throw new IllegalArgumentException();
    }


    private boolean isDigit() {
        return roundCount.matches(Constant.REGEXP_ROUND_NUM);
    }

    private boolean isMinRoundCount() {
        return Integer.parseInt(roundCount) >= Constant.ROUND_MINIMUM_NUM;
    }

}
