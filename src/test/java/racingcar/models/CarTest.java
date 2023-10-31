package racingcar.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차_이름_생성_테스트() {
        // given
        String name = "pobi";

        // when
        Car car = new Car(name);

        // then
        assertEquals(name, car.getName());
    }

    @Test
    void 자동차_전진_테스트() {
        // given
        Car car = new Car("pobi");

        // when
        car.proceed();

        // then
        assertEquals(1, car.getMoveDistance());
    }

}