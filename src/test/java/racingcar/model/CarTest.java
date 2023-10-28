package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void createCar_success() {
        String carName = "pobi";
        Car car = new Car(carName);

        assertEquals(carName, car.getName());
    }

    @Test
    void createCar_fail_invalid_name_length() {
        String carName = "pobiiii";

        assertThrows(IllegalArgumentException.class, () -> {
            new Car(carName);
        });
    }

    @Test
    void createCar_fail_empty_name() {
        String carName = "";

        assertThrows(IllegalArgumentException.class, () -> {
            new Car(carName);
        });
    }

    @Test
    void accelerate() {
        CarAccelerator carAccelerator = new CarAccelerator();
        carAccelerator.setFakeRandoms();

        Car car = new Car("pobi");
        int beforeAccelerate = car.getTotalMovingDistance();

        car.accelerate(carAccelerator);

        int afterAccelerate = car.getTotalMovingDistance();

        assertEquals(beforeAccelerate, afterAccelerate);
    }
}