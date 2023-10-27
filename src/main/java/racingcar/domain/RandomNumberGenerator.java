package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberGenerator {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    public static int randomNumGenerate(){
        return Randoms.pickNumberInRange(START_INCLUSIVE,END_INCLUSIVE);
    }
}
