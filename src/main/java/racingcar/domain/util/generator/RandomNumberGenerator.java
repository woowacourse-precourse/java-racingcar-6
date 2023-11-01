package racingcar.domain.util.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.config.GameConfig;

public class RandomNumberGenerator {
    private static final int RANDOM_MINIMUM = GameConfig.RANDOM_MINIMUM;
    private static final int RANDOM_MAXIMUM = GameConfig.RANDOM_MAXIMUM;

    public static List<Integer> createListNumber(int listNumber) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < listNumber; i++) {
            int between0and9 = Randoms.pickNumberInRange(RANDOM_MINIMUM, RANDOM_MAXIMUM);
            result.add(between0and9);
        }
        return result;
    }
}
