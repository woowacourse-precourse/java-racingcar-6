package racingcar.domain.gameInfo;

import racingcar.validation.InputGameInfoValidate;

public class InputProgressCount {
    private final int progressCount;

    public InputProgressCount(String inputProgressCount) {
        InputProgressCountValidation(inputProgressCount);
        this.progressCount = Integer.parseInt(inputProgressCount);
    }

    public int getProgressCount() {
        return progressCount;
    }

    private void InputProgressCountValidation(String inputProgressCount) {
        InputGameInfoValidate.gameProgressNotValueValidate(inputProgressCount);
        int tryCount = Integer.parseInt(inputProgressCount);
        InputGameInfoValidate.gameProgressCountThanZeroValidate(tryCount);
    }
}
