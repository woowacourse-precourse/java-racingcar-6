package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car("pobi");
    }

    @Test
    @DisplayName("자동차가 이동하는 경우")
    void moveTest1() {
        int firstPostion = car.getPosition();
        car.move(1);
        int secondPostion = car.getPosition();

        assertThat(firstPostion).isEqualTo(0);
        assertThat(secondPostion).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 이동하지 않는 경우")
    void moveTest2() {
        int firstPostion = car.getPosition();
        car.move(0);
        int secondPostion = car.getPosition();

        assertThat(firstPostion).isEqualTo(0);
        assertThat(secondPostion).isEqualTo(0);
    }
}
