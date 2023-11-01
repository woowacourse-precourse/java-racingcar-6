package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 랜덤값으로_전진() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woowa");

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    car1.move();
                    car2.move();

                    // then
                    assertThat(car1.getNowNum()).isEqualTo(1);
                    assertThat(car2.getNowNum()).isEqualTo(0);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
