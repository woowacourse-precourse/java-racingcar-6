package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    @Test
    void 자동차_생성_테스트() {
        String carName = "tayo";
        Car car = CarGenerator.createCar(carName);
        assertEquals(carName, car.getName());
    }
}