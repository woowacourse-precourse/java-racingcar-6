package racingcar.util;

public final class RandomNumberGenerator {
    private RandomNumberGenerator() {
    }

    private static int number;

    public static int getNumber() {
        number = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);

        return number;
    }
}
