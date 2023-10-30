package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void move() {
        // given
        String carName = "pony";
        Car car = new Car(carName);

        // when
        car.move();
        car.move();
        int findPosition = car.getPosition();
        String findName = car.getName();

        // then
        assertThat(findPosition).isEqualTo(2);
        assertThat(findName).isEqualTo(carName);
    }
}