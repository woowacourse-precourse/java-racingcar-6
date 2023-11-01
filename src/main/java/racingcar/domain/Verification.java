package racingcar.domain;

public class Verification {
    public boolean isFiveOrLess(String carName) {
        String[] split = carName.split("");
        return split.length <= 5;
    }
}
