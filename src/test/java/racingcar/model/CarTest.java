package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("foward: 함수를 호출하면 position이 1씩 증가한다")
    void foward() {
        Car car = new Car("a");

        for (Long i = 0L; i < 10; i++) {
            car.foward();
            assertEquals(i + 1, car.getPosition());
        }
    }
}