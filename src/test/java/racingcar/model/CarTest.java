package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void create_one_car() {
        // given
        String name = "car";

        // when
        Car car = new Car(name);

        // then
        Assertions.assertThat(car.getCarName()).isEqualTo(name);
        Assertions.assertThat(car.getDriveCount()).isEqualTo(0);

    }

    @Test
    public void create_one_more_car() {
        // given
        String name1 = "abc";
        String name2 = "def";

        // when
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);

        // then
        Assertions.assertThat(car1.getCarName()).isEqualTo(name1);
        Assertions.assertThat(car1.getDriveCount()).isEqualTo(0);

        Assertions.assertThat(car2.getCarName()).isEqualTo(name2);
        Assertions.assertThat(car2.getDriveCount()).isEqualTo(0);
    }
}
