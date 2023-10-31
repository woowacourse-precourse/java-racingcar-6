package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4,9})
    void go_랜덤값이_기준값_이상이면_거리_증가(int randomNumber) {
        Car car = new Car("test");
        int initialDistance = car.getDistance();

        car.go(randomNumber);
        int updatedDistance = car.getDistance();

        assertEquals(updatedDistance, initialDistance + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,3})
    void go_랜덤값이_기준값_미만이면_거리_변경_없음(int randomNumber) {
        Car car = new Car("test");
        int initialDistance = car.getDistance();

        car.go(randomNumber);
        int updatedDistance = car.getDistance();

        assertEquals(updatedDistance, initialDistance);
    }

}