package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class RandomNumberGenerator  implements NumberGenerator{
    private static final Random random = new Random();

    @Override
    public int generate(int bound) {
        return random.nextInt(bound + 1);
    }


}
