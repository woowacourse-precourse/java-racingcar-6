package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    void 자동차_전진_기능(){
        Car car = new Car("car1");
        Assertions.assertEquals(1,  car.movesForward());
    }
}
