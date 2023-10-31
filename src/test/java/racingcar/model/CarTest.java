package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void getMoveLength_차가_움직인_거리_반환() {
        Car car = new Car("harry");
        assertThat(car.getMoveLength()).isEqualTo(0);
    }

    @Test
    void getCarName_차_이름_반환() {
        Car car = new Car("harry");
        assertThat(car.getCarName()).isEqualTo("harry");
    }

}
