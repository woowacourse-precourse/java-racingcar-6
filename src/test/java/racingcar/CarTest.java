package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final int STEP = 3;
    private final int MOVE_CONDITION = 4;

    @Test
    void 자동차_전진() {
        Car car = new Car("name");
        for (int i=0; i < STEP; i++)
            car.moveOrStop(MOVE_CONDITION + 1);
        assertThat(car.getStatus()).isEqualTo(STEP);
    }

    @Test
    void 자동차_정지() {
        Car car = new Car("name");
        for (int i=0; i < STEP; i++)
            car.moveOrStop(MOVE_CONDITION - 1);
        assertThat(car.getStatus()).isEqualTo(0);
    }
}