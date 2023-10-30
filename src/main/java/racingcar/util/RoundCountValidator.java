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
        return roundCount.matches("^[1-9]\\d*$");
    }

    private boolean isMinRoundCount() {
        return Integer.parseInt(roundCount) >= 1;
    }

}
