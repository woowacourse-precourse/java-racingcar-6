package racingcar.domain;

import org.assertj.core.api.Assertions;
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
    @DisplayName("자동차가 5 이상 이동하는 경우")
    void moveTest1() {
        int firstPostion = car.getPosition();
        car.move(6);
        int secondPostion = car.getPosition();

        Assertions.assertThat(firstPostion).isEqualTo(0);
        Assertions.assertThat(secondPostion).isEqualTo(6);
    }

    @Test
    @DisplayName("자동차가 0만큼 이동하는 경우")
    void moveTest2() {
        int firstPostion = car.getPosition();
        car.move(0);
        int secondPostion = car.getPosition();

        Assertions.assertThat(firstPostion).isEqualTo(0);
        Assertions.assertThat(secondPostion).isEqualTo(0);
    }
}