package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void moveTest() {
        Car car = new Car("myCar");
        boolean isMoveCondition = car.isMoveCondition();
        car.move(isMoveCondition);
        if (car.isMoveCondition()) {
            assertThat(car.getStatus().equals("-"));
        } else {
            assertThat(car.getStatus().isEmpty());
        }
    }
}