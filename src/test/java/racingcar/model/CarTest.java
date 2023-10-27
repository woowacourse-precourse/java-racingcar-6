package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;
    @Test
    void Car_생성() {
        car = new Car("pobi", 4);

        Assertions.assertThat(car.getCarName()).isEqualTo("pobi");
        Assertions.assertThat(car.getDistance()).isEqualTo(4);
        Assertions.assertThat(car).isEqualTo(new Car("pobi", 4));
    }

    @Test
    void Car_4이상이면_전진한다() {
        car = new Car("pobi", 5);
        car.move(4);

        Assertions.assertThat(car.getDistance()).isEqualTo(6);
    }

    @Test
    void Car_4보다_작으면_전진하지_않는다() {
        car = new Car("pobi", 5);
        car.move(3);

        Assertions.assertThat(car.getDistance()).isEqualTo(5);
    }

}
