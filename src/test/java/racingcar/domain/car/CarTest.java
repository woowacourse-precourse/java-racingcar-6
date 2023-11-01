package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @AfterEach
    void tearDown() {
        car = null;
    }

    @Test
    @DisplayName("차가 앞으로 전진합니다.")
    void moveForward() {
        // GIVEN
        car = Car.createCar("pobi", 0);
        int moveTrial = 3;

        // WHEN
        for (int i = 0; i < moveTrial; i++) {
            car.moveForward();
        }

        // THEN
        assertEquals(moveTrial, car.getCurrentLocation());
    }

    @Test
    @DisplayName("Car가  전진 후 toString을 호출 시, 본인의 상태를 문자열로 반환합니다.")
    void testToString() {
        // GIVEN
        car = Car.createCar("pobi", 0);
        int moveTrial = 3;
        for (int i = 0; i < moveTrial; i++) {
            car.moveForward();
        }
        String expectedStatus = "pobi : ---";

        // WHEN
        String actualStatus = car.toString();

        // THEN
        assertEquals(expectedStatus, actualStatus);
    }
}