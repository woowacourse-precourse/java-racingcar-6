package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void moveTest() {
        //given
        Car car = new Car("hoho");
        Position position = new Position();
        //when
        car.move(5);
        position.moveForward(1);

        //then
        Assertions.assertEquals(car.getPosition(), position.toInt());
    }
}