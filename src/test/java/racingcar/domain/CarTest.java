package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_전진_시_score_1_증가() {
        Car car = new Car("pobi");
        car.go();
        assertEquals(1, car.getScore());
    }
}
