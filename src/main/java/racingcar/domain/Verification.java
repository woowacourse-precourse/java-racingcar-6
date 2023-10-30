package racingcar.domain;

public class Verification {
    public boolean isLessThanFive(String carName) {
        String[] split = carName.split("");
        return split.length <= 5;
    }
}
