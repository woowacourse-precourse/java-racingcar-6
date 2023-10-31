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

        int carACount = carA.getCurrentPosition();
        int carBCount = carB.getCurrentPosition();
        assertThat(carBCount).isLessThan(carACount);
    }

}
