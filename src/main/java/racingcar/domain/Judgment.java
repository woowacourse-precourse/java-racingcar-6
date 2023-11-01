package racingcar.domain;

import java.util.Arrays;

public class Judgment {

    public String[] getSplitCarNames(String carNames) {
        String[] splitCarNames = carNames.split(",");
        return splitCarNames;
    }

    public void validateCarNames(String[] carNames) {
        final int MAX_RANGE = 5;
        boolean isValidateCarNames = Arrays.stream(carNames).allMatch((carName) -> carName.length() <= MAX_RANGE);
        if (!isValidateCarNames) {
            throw new IllegalArgumentException("car name length out of range: 5");
        }
    }
}
