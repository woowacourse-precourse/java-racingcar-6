package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.CarName;

class CarTest {

    private static final Integer INIT_STEP = 0;

    private Car car;

    @DisplayName("자동차 이름이 5자 이하인 경우 예외 발생 없이, 객체가 생성된다.")
    @Test
    void constructorValidCarName_test() {
        // given
        CarName carName = new CarName("12345");

        // when
        car = new Car(carName);

        // then
        assertNotNull(car);
        assertEquals(carName.name(), car.getCarName().name());
        assertEquals(INIT_STEP, car.getStep());
    }
}