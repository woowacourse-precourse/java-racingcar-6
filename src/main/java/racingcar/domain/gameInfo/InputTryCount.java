package racingcar.domain.gameInfo;

import racingcar.validation.InputGameInfoValidate;

public class InputTryCount {
    private final int inputTryCount;

    public InputTryCount(String inputTryCount) {
        InputTryCountValidation(inputTryCount);
        this.inputTryCount = Integer.parseInt(inputTryCount);
    }

    public int getInputTryCount() {
        return inputTryCount;
    }

    private void InputTryCountValidation(String inputTryCount){
        InputGameInfoValidate.gameProgressNotValueValidate(inputTryCount);
        int tryCount = Integer.parseInt(inputTryCount);
        InputGameInfoValidate.gameProgressCountThanZeroValidate(tryCount);
    }
}
