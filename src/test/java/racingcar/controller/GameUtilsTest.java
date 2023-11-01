package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class GameUtilsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("carFactory: 주어진 이름을 가진 cars array를 생성한다")
    void carFactory() {
        List<String> names = List.of("a", "b", "c");
        List<Car> cars = GameUtils.carFactory(names);

        assertThat(cars.size()).isEqualTo(names.size());
        for (int i = 0; i < names.size(); i++) {
            assertThat(cars.get(i).getPosition()).isEqualTo(0);
            assertThat(cars.get(i).getName()).isEqualTo(names.get(i));
        }
    }

    @Test
    @DisplayName("canFoward: 생성된 난수에 따라 자동차의 이동 여부를 결정한다")
    void canFoward() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertTrue(GameUtils.canForward());
                    assertFalse(GameUtils.canForward());
                },
                MOVING_FORWARD, STOP
        );
    }
}