package racingcar.car;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    public static final String TEST_NAME = "testName";
    public static final String RESULT = "testName : --";

    @Test
    void 자동차_전진_테스트() {
        Car car = Car.of(TEST_NAME);
        int moveCountAfterMove = car.getForwardMoveCount()+1;
        car.move();
        assertThat(car.getForwardMoveCount()).isEqualTo(moveCountAfterMove);
    }

    @Test
    void 이름_부여_테스트() {
        String carName = TEST_NAME;
        Car car = Car.of(carName);
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    void 자동차_결과_테스트() {
        Car car = Car.of(TEST_NAME);
        car.move();
        car.move();
        assertThat(car.makeResult()).isEqualTo(RESULT);
    }

}