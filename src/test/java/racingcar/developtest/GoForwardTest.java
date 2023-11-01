package racingcar.developtest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class GoForwardTest {
    private static final int MOVING_FORWARD_BOUND = 4;
    private static final int STOP_BOUND = 3;

    @Test
    void proceedOwnRound_4일때_전진_합니다() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(() -> {
            car.proceedOwnRound();
            assertThat(car.getFormattedPosition()).isEqualTo("pobi : -");
        }, MOVING_FORWARD_BOUND);
    }

    @Test
    void proceedOwnRound_9일때_전진_합니다() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(() -> {
            car.proceedOwnRound();
            assertThat(car.getFormattedPosition()).isEqualTo("pobi : -");
        }, 9);
    }

    @Test
    void proceedOwnRound_3일때_정지_합니다() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(() -> {
            car.proceedOwnRound();
            assertThat(car.getFormattedPosition()).isEqualTo("pobi : ");
        }, STOP_BOUND);
    }

    @Test
    void proceedOwnRound_0일때_정지_합니다() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(() -> {
            car.proceedOwnRound();
            assertThat(car.getFormattedPosition()).isEqualTo("pobi : ");
        }, 0);
    }

    @Test
    void proceedOwnRound_앞으로_두번_전진_합니다() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(() -> {
            car.proceedOwnRound();
            car.proceedOwnRound();
            assertThat(car.getFormattedPosition()).isEqualTo("pobi : --");
        }, MOVING_FORWARD_BOUND);
    }

    @Test
    void proceedOwnRound_두번_정지_합니다() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(() -> {
            car.proceedOwnRound();
            car.proceedOwnRound();
            assertThat(car.getFormattedPosition()).isEqualTo("pobi : ");
        }, STOP_BOUND);
    }


}
