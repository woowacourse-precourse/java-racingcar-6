package racingcar.domain.core.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차는 이름을 가진다.")
    void create() {
        // given
        String name = "name";

        // when
        Car car = new Car(new CarName(name));

        // then
        assertEquals(car.getCarName(), new CarName(name));
    }
}