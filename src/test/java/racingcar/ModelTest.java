package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModelTest {
    @Test
    void Car_생성() {
        Car car = new Car("pobi", 4);

        Assertions.assertThat(car.getCarName()).isEqualTo("pobi");
        Assertions.assertThat(car.getDistance()).isEqualTo(4);
        Assertions.assertThat(car).isEqualTo(new Car("pobi", 4));
    }

}
