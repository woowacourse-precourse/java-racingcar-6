package racingcar.domain;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static racingcar.system.SystemConstant.MIN_MOVE_THRESHOLD;


class RoundManagerTest {

    private final RoundManager roundManager = new RoundManager();

    private List<Car> cars = Arrays.asList(new Car("pobi",3));

    @Test
    void 랜덤값이_4이상인_전진하는_경우() {
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    roundManager.moveCars(cars);
                    org.assertj.core.api.Assertions.assertThat(cars.get(0).getTotalMovedDistance())
                            .isEqualTo(MIN_MOVE_THRESHOLD);
                },
                MIN_MOVE_THRESHOLD
        );

    }


}