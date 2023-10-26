package racingcar.model;

public class TrialNumber {
    private final int trialNumber;

    public TrialNumber(String trialNumber) {
        checkIsNumber(trialNumber);
        this.trialNumber = Integer.parseInt(trialNumber);
    }

    private void checkIsNumber(String trialNumber) {
        for (char c : trialNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자를 입력해야 합니다.");
            }
        }
    }

    public int getTrialNumber() {
        return trialNumber;
    }
}
