package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("만약 자동차가 실제 이동했다면 위치는 1 증가해야 한다. 그렇지 않다면 위치는 그대로이다.")
    void move() {
        Car pobiCar = new Car("pobi", 0);

        if (pobiCar.move()) {
            Assertions.assertThat(pobiCar.getPosition() == 1).isTrue();
        } else {
            Assertions.assertThat(pobiCar.getPosition() == 0).isTrue();
        }
    }
}
