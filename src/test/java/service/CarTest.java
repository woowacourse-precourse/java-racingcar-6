package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void go_랜덤값이_기준값_이상이면_거리_증가() {
        Car car = new Car("test");
        int initialDistance = car.getDistance();

        car.go(4);
        int updatedDistance = car.getDistance();

        assertEquals(updatedDistance, initialDistance + 1);
    }

    @Test
    void go_랜덤값이_기준값_미만이면_거리_변경_없음() {
        Car car = new Car("test");
        int initialDistance = car.getDistance();

        car.go(3);
        int updatedDistance = car.getDistance();

        assertEquals(updatedDistance, initialDistance);
    }

}