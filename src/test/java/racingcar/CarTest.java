package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest extends NsTest {

    private final Car testCar = new Car("test");

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("move 메서드 전진 테스트")
    void move_go() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(testCar.toString())
                            .isEqualTo("test : -");
                },
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("move 메서드 전진 실패 테스트")
    void move_not_go() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(testCar.toString())
                            .isEqualTo("test : ");
                },
                STOP
        );
    }

    @Override
    protected void runMain() {
        testCar.move();
    }
}
