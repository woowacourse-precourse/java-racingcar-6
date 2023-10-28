package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 값이_4이상인경우_1번전진한다() {
        // given
        Car car = new Car("pobi", 0);

        // when
        car.moveAccordingToInput(4);

        // then
        assertThat(car.getMovingCount()).isEqualTo(1);
    }

    @Test
    void 값이_3이하인경우_정지한다() {
        // given
        Car car = new Car("pobi", 0);

        // when
        car.moveAccordingToInput(3);

        // then
        assertThat(car.getMovingCount()).isEqualTo(0);
    }
}
