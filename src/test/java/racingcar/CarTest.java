package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;
    private static final int GREATER_THAN_FOUR = 4;
    private static final int LESS_THAN_FOUR = 3;
    private static final int STOP = 0;
    private static final int GO = 1;

    @BeforeEach
    void createCar() {
        car = new Car("car1");
    }

    @Test
    void 랜덤_숫자_4_이상이면_전진() {

        int forwardCount = car.compareNumberAndMove(GREATER_THAN_FOUR);

        assertThat(forwardCount).isEqualTo(GO);
    }

    @Test
    void 랜덤_숫자_4_미만이면_정지() {

        int forwardCount = car.compareNumberAndMove(LESS_THAN_FOUR);

        assertThat(forwardCount).isEqualTo(STOP);
    }
}
