package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.TestConstant;

@DisplayName("자동차 도메인에 대한 테스트")
class CarTest extends NsTest {
    @Test
    @DisplayName("무작위 값이 4 이상인 경우 전진 여부 테스트")
    void moveForwardTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).isEqualTo(String.valueOf(1));
                },
                TestConstant.REFERENCE_VALUE_MOVING_FORWARD, TestConstant.MAX_RANDOM_NUMBER
        );
    }

    @Test
    @DisplayName("무작위 값이 4 미만인 경우 전진 여부 테스트")
    void noMoveForwardTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).isEqualTo(String.valueOf(0));
                },
                TestConstant.MIN_RANDOM_NUMBER, TestConstant.REFERENCE_VALUE_MOVING_FORWARD - 1
        );
    }

    @Override
    protected void runMain() {
        Car car = new Car(TestConstant.TEST_CAR_NAME_1);
        car.moveForward();
        System.out.println(car.getForwards());
    }
}