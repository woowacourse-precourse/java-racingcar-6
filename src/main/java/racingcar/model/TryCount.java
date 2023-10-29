package racingcar.model;

import racingcar.validator.Validator;

public class TryCount {
    private final int tryCount;

    public TryCount(String stringTryCount) {
        this.tryCount = convertStringToInt(stringTryCount);
        Validator.checkInputNumberPositive(this.tryCount);

    }

    // 입력한 숫자와 현재 진행 중인 시도 횟수가 같아지면 끝냄
    public boolean isSame(int tryCount) {
        return this.tryCount == tryCount;
    }

    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
