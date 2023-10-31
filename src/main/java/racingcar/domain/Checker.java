package racingcar.domain;

public class Checker {

    public static boolean checkAtLest4(int num) {
        if (num < 0 || num > 9) {
            throw new IllegalArgumentException("불가능한 값이 들어왔습니다.");
        }

        if (num >= 4) {
            return true;
        }

        return false;
    }
}
