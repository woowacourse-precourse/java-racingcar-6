package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차의_객체를_생성() {
        
        Car car = new Car("car1",0);

        String carName = car.getCarName();
        int carPosition = car.getPosition();

        assertAll(
                () -> assertEquals("car1", carName),
                ()->assertEquals(0,carPosition)
        );
    }

    @Test
    void 자동차의_위치를_증가() {

        Car car = new Car("car1",0);

        car.increasePosition();

        assertEquals(1,car.getPosition());
    }
}
