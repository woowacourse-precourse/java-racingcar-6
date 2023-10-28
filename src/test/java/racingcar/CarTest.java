package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.LinkedHashMap;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("testCar");
    }

    @Test
    void 자동차_전진_테스트() {
        car.move();
        Assertions.assertEquals(1, car.getPosition());
    }

    @Test
    void 자동차_무작위_값_생성_테스트() {
        int carNumber = car.createRandomNumber();
        Assertions.assertTrue(carNumber >= 0 && carNumber <= 9);
    }


    @Test
    void 자동차_이름_게터_테스트() {
        Assertions.assertEquals("testCar", car.getName());
    }

    @Test
    void 자동차_위치_게터_테스트() {
        Assertions.assertEquals(0, car.getPosition());
    }


}
