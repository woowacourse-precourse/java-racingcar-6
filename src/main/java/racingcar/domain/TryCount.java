package racingcar.domain;

import java.util.Objects;

public class TryCount {

    private final int tryCount;

    public TryCount(final String tryCount) {
        isNaturalNumberValidate(tryCount);
        this.tryCount = convertStringToInt(tryCount);
    }

    private void isNaturalNumberValidate(String tryCount) {
        if (!tryCount.matches("^[1-9]\\d*$")){
            throw new IllegalArgumentException("이동할 횟수는 자연수여야 한다.");
        }
    }

    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public int getTryCount() {
        return tryCount;
    }
}
