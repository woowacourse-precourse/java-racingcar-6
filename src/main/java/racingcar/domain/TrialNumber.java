package racingcar.domain;

import racingcar.view.OutputView;

public class TrialNumber {
    private final int trialNumber;

    public TrialNumber(String trialNumberInput) {
        int trialNumber = convertTrialNumberInputToInteger(trialNumberInput);
        this.trialNumber = trialNumber;
    }

    public void playTurnAsMuchAsTrialNumber(Cars cars) {
        OutputView.printFirstShownResultText();
        for (int trial = 0; trial < trialNumber; trial++) {
            cars.playTurn();
        }
    }

    private int convertTrialNumberInputToInteger(String trialNumberInput) {
        validateTrialNumberNotInteger(trialNumberInput);
        return Integer.parseInt(trialNumberInput);
    }

    private void validateTrialNumberNotInteger(String trialNumber) {
        if (trialNumber.matches("\\d*")) {
            return;
        }
        throw new IllegalArgumentException("시도 횟수는 정수를 입력해주세요.");
    }
}
