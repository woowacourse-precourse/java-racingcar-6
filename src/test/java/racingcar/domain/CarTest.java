package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
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
    void 자동차의_객체를_여러개_생성() {

        Car[] car = new Car[3];

        car[0] = new Car("car1",0);
        car[1] = new Car("car2",0);
        car[2] = new Car("car3",0);

        List<String> carsName = new ArrayList<>();
        List<Integer> carsPosition = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            carsName.add(car[i].getCarName());
            carsPosition.add(car[i].getPosition());
        }

        assertAll(
                () -> assertEquals("car1", carsName.get(0)),
                ()->assertEquals(0,carsPosition.get(0)),
                () -> assertEquals("car2", carsName.get(1)),
                ()->assertEquals(0,carsPosition.get(1)),
                () -> assertEquals("car3", carsName.get(2)),
                ()->assertEquals(0,carsPosition.get(2))
        );
    }

    @Test
    void 자동차의_위치를_증가() {

        Car car = new Car("car1",0);

        car.increasePosition();

        assertEquals(1,car.getPosition());
    }
}
