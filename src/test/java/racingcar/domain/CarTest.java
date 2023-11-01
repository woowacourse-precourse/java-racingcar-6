package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    Car car = new Car("car");

    @Test
    void getRandomNum() {
        int randomNum = car.getRandomNum();
        Assertions.assertThat(randomNum).isGreaterThan(-1).isLessThan(10);
    }

    @Test
    void moveForward() {
    }

    @Test
    void race() {
    }

    @Test
    void getCarStatus() {
    }

    @Test
    void isWinner() {
    }

    @Test
    void getName() {
    }
}