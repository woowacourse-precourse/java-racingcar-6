package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.CarName;

class CarTest {

    private static final Integer INIT_DISTANCE = 0;

    private Car car;

    @DisplayName("자동차 이름이 5자 이하인 경우 예외 발생 없이, 객체가 생성된다.")
    @Test
    void valid_carName_test() {
        // given
        CarName carName = new CarName("12345");

        // when
        car = new Car(carName);

        // then
        assertNotNull(car);
        assertEquals(carName.name(), car.getCarName().name());
        assertEquals(INIT_DISTANCE, car.getCarPosition().position());
    }

    @DisplayName("자동차 이름이 6자 이상인 경우 예외가 발생한다.")
    @Test
    void inValid_carName_test() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarName carName = new CarName("123456");
        });
    }
}
