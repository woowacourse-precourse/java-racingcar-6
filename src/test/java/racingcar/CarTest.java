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
    void 자동차의_이동거리를_문자열로_반환() {
        Car car = new Car("test");
        int[] moves = {MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD};
        move_car(car, moves);
        assertThat(car.getCurrentResult()).isEqualTo("test : ---");
    }
    @Test
    void 다른_자동차와_거리를_비교() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        move_car(car1, new int[]{MOVING_FORWARD, MOVING_FORWARD});
        move_car(car2, new int[]{MOVING_FORWARD});
        assertThat(car1.compareTo(car2)).isEqualTo(1);

        move_car(car2, new int[]{MOVING_FORWARD, MOVING_FORWARD});
        assertThat(car1.compareTo(car2)).isEqualTo(-1);
    }

    void move_car(Car car, int[] numbers) {
        for (int number : numbers) {
            assertRandomNumberInRangeTest(
                    () -> {
                        car.move();
                    },
                    number
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
