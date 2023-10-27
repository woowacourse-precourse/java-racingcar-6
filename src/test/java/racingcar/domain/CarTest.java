package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void 자동차_이동_테스트() {

        Car carA = new Car("자동차1");
        Car carB = new Car("자동차2");

        carA.forward();
        carA.forward();
        carA.forward();
        carA.forward();

        int carACount = carA.getForwardCount();
        int carBCount = carB.getForwardCount();
        assertThat(carBCount).isLessThanOrEqualTo(carACount);
    }

}
