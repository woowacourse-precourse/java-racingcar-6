package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private RacingCar car;

    @BeforeEach
    void setUp() {
        car = new RacingCar("justin");
    }

    @Test
    void 무작위_값에_따라_이동하는지_확인() {
        car.move();
    }

    @Test
    void 실행_결과_제대로_출력되는지_확인() {
        car.move();
        car.move();
        car.move();
        car.move();
        car.move();
        car.display();
    }
}