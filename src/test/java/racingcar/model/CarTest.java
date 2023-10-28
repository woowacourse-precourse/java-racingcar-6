package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private static final Integer INIT_STEP = 0;

    private Car car;

    @DisplayName("자동차 이름이 6자 이상인 경우 예외가 발생한다.")
    @Test
    void constructorInvalidCarName_exception_test() {
        String name = "123456";

        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @DisplayName("자동차 이름이 5자 이하인 경우 예외 발생 없이, 객체가 생성된다.")
    @Test
    void constructorValidCarName_test() {
        // given
        String carName = "Car1";

        // when
        car = new Car(carName);

        // then
        assertNotNull(car);
        assertEquals(carName, car.getName());
        assertEquals(INIT_STEP, car.getStep());
    }
}