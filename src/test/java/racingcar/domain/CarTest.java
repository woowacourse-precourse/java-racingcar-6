package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void getName_이름_반환() {
        Car car = new Car("Car1");
        assertThat(car.getName()).isEqualTo("myCar1");
    }

    @Test
    void getDist_디폴트_상태() {
        Car car = new Car("Car2");
        assertThat(car.getDist()).isEqualTo(0);
    }

    @Test
    void move_전진() {
        Car car = new Car("Car3");
        car.move();
        assertThat(car.getDist()).isEqualTo(1);
    }
}
