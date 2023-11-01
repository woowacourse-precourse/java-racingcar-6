package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car 테스트")
class CarTest {

    @DisplayName("자동차 움직임 테스트")
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