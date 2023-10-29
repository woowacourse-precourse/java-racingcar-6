package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car("goodCar", 0);
    }

    @Test
    void move() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            assertThat(car.getPosition() == 1);
        } else {
            assertThat(car.getPosition() == 0);
        }
    }

    @Test
    void showCarPosition() {
        car.setPosition(1);
        assertThat(car.showCarPosition().equals("goodCar : -"));
        car.setPosition(2);
        assertThat(car.showCarPosition().equals("goodCar : --"));
    }
}