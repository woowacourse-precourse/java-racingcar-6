package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void generateRandomNumber() {
        Car car = new Car("상추");
        int randomNumber = car.generateRandomNumber();
        assertThat(randomNumber).isBetween(0, 1);
    }
}