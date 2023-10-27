package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void Car_move_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                Car car = new Car("testCar");
                for(int i = 0; i < 3; i++) {
                    car.move();
                }
                assertThat(car.getPosition()).isEqualTo(2);
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void Car_toString_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("testCar");
                    for(int i = 0; i < 3; i++) {
                        car.move();
                    }
                    assertThat(car.toString()).isEqualTo("testCar : --");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("testCar");
                    for(int i = 0; i < 3; i++) {
                        car.move();
                    }
                    assertThat(car.toString()).isEqualTo("testCar : ");
                },
                STOP, STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
