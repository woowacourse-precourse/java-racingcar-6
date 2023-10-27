package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.Rule;

public class CarTest {

    private Car car;


    @DisplayName("자동차 이름을 반환한다.")
    @Test
    void getCarName() {

        car = new Car("pobi");

        Assertions.assertAll(
                () -> Assertions.assertEquals("pobi", car.getCarName()),
                () -> Assertions.assertNotEquals("seok", car.getCarName())
        );
    }

    @DisplayName("자동차 포지션을 반환한다.")
    @Test
    void getPosition() {

        car = new Car("pobi");
        Position position = new Position(0);
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, car.getCarPosition()),
                () -> Assertions.assertEquals(position, car.getPosition())
        );
    }

    @DisplayName("자동차가 rule에 기반하여 한칸 움직이거나 정지한다.")
    @Test
    void move() {
        Car car = new Car("pobi");

        car.move(new Rule(), 3);
        Assertions.assertEquals(0, car.getCarPosition());

        car.move(new Rule(), 5);
        Assertions.assertEquals(1, car.getCarPosition());
    }

    @DisplayName("자동차의 현재 위치를 반환한다")
    @Test
    void getCarPosition(){
        Car car = new Car("pobi");

        Assertions.assertEquals(0,car.getCarPosition());
    }

}
