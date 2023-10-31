package racingcar.domain;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차_객체_전진_증가_테스트() {
        Car car = new Car("robin");
        Car car2 = new Car("nope");
        assertSimpleTest(() -> {
            assertThat(car.getForwardNum()).isEqualTo(0);
            car.increaseForwardNum();
            car2.increaseForwardNum();
            assertThat(car.getForwardNum()).isEqualTo(1);
        });

    }
}
