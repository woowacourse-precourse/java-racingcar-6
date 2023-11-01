package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    void 실행_결과_test() {
        Car car = new Car("abc");
        car.setScore(3);

        String result = car.printResult();

        assertEquals("abc : ---", result);
    }

    @Test
    void zero_Score_test() {
        Car car = new Car("abc");
        car.setScore(0);

        String result = car.printResult();

        assertEquals("abc : ", result);
    }



}
