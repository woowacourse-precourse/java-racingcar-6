package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void tryMoveCarTest1() {
        Car car = new Car();
        for (int i = 0; i < 5; i++ ){
        car.tryMoveCar();
        System.out.println(car.carPosition);
        }
    }
}