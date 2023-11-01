package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 생성자_테스트() {
        String name = "carName";

        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void move_테스트() {
        Car car = new Car("carName");

        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void getName_테스트() {
        String name = "carName";

        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void getPosition_테스트() {
        Car car = new Car("carName");

        assertThat(car.getPosition()).isEqualTo(0);
    }

}
