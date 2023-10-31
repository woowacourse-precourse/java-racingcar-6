package racingcar.model;

public class TrialNumber {
    private int trial;

    public TrialNumber(String input) {
        validateTrialNumber(input);
        this.trial = Integer.parseInt(input);
    }

    public void decreaseTrialNumber() {
        trial--;
    }

    public boolean isTrialNumberZero() {
        return trial == 0;
    }

    private void validateTrialNumber(String input) {
        validateTrialNumberIsInt(input);
        validateTrialNumberRange(input);
    }

    private void validateTrialNumberIsInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateTrialNumberRange(String input) {
        int intValue = Integer.parseInt(input);
        if (intValue <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
