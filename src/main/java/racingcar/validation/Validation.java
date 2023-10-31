package racingcar.validation;

public class Validation {
    public static boolean isNumberInRange(int random) {
        if (random < 0 || 9 < random) {
            throw new IllegalArgumentException("random 값 범위 초과, 범위 : 0 ~ 9");
        }
        return true;
    }
}
