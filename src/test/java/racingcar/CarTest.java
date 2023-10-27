package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest extends NsTest{
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동자의_이동거리를_문자열로_반환() {
        Car car = new Car("test");
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 4; i++) {
                        car.move();
                    }
                    assertThat(car.getCurrentResult()).isEqualTo("test : ---");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
