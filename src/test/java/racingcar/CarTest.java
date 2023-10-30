package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_getName() {
        String name = "Ford";
        CarName carName = new CarName(name);
        Car mustang = new Car(carName);

        assertEquals(name, mustang.getName());
    }

    @Test
    void 자동차_drive() {
        String name = "Ford";
        CarName carName = new CarName(name);
        Car mustang = new Car(carName);

        mustang.drive();

        assertEquals(1, mustang.getPosition());
    }

}