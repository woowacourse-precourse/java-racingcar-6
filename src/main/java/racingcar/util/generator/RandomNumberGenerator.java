package racingcar.util.generator;


import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;

    @Override
    public int generate() {
        final int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        return randomNumber;
    }
}
