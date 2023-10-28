package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.config.GameConfig;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate(int size) {
        return IntStream.range(0, size)
                .mapToObj(number ->
                        Randoms.pickNumberInRange(GameConfig.MOVING_MIN_VALUE, GameConfig.MOVING_MAX_VALUE))
                .toList();
    }
}
