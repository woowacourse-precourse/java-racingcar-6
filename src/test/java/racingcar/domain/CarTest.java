package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_전진하면_위치가_1_증가한다() {
        Car car = new Car("pobi");
        car.go();
        assertEquals(1, car.getPosition());

        car.go();
        assertEquals(2, car.getPosition());
    }
}