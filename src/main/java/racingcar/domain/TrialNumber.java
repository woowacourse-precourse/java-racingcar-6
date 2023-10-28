package racingcar.domain;

public class TrialNumber {
    int trialNumber;

    public TrialNumber(String trialNumberInput) {
        int trialNumber = convertTrialNumberInputToInteger(trialNumberInput);
        this.trialNumber = trialNumber;
    }

    public void playTurnAsMuchAsTrialNumber(Cars cars) {
        for (int trial = 0; trial < trialNumber; trial++) {
            cars.playTurn();
        }
    }
    public int convertTrialNumberInputToInteger(String trialNumberInput) {
        validateTrialNumberNotInteger(trialNumberInput);
        return Integer.parseInt(trialNumberInput);
    }

    public void validateTrialNumberNotInteger(String trialNumber) {
        if (trialNumber.matches("\\d*")) {
            return;
        }
        throw new IllegalArgumentException("시도 횟수는 정수를 입력해주세요.");
    }
}
