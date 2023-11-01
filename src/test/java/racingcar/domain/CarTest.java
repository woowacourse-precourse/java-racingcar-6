package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_테스트()  {
        Car car = new Car("test");
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    car.move();
                    car.move();

                    assertThat(car.getPostion()).isEqualTo(2);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 상태_테스트()  {
        Car car = new Car("test");
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    car.move();
                    car.move();

                    assertThat(car.status()).isEqualTo("test : --");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
}
