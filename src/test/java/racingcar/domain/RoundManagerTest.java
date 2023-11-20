package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.system.SystemConstant.MIN_MOVE_THRESHOLD;


class RoundManagerTest {

    private final RoundManager roundManager = new RoundManager();

    private List<Car> cars = Arrays.asList(new Car("pobi"));

    @Test
    void 랜덤값이_4이상인_전진하는_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    Cars raceCars = new Cars(cars);
                    roundManager.moveCars(raceCars);
                    assertThat(cars.get(0).getTotalMovedDistance())
                            .isEqualTo(1);
                },
                MIN_MOVE_THRESHOLD
        );

    }

    @Test
    void 랜덤값이_4미만인_전진하지않는_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    Cars raceCars = new Cars(cars);
                    roundManager.moveCars(raceCars);
                    assertThat(cars.get(0).getTotalMovedDistance())
                            .isEqualTo(0);
                },
                2
        );
    }
}