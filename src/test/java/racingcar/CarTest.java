package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    void 전진_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("FIRS");
                    assertThat(car.move()).isEqualTo(1);
                },
                5
        );
    }

    @Test
    void 정지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("FIRS");
                    assertThat(car.move()).isEqualTo(0);
                },
                3
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}