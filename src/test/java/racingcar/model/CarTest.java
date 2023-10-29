package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_전진_기능() {
        int randomNumber = 5;
        Car car = new Car("pobi");
        int curPosition = car.getPosition();
        car.forward(randomNumber);
        Assertions.assertThat(curPosition + 1).isEqualTo(car.getPosition());
    }
}
