package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static racingcar.Util.generateRandomNumber;

public class CarTest {

    @Test
    void 자동차_이동기능_테스트() {
        Car testCar = new Car("승호");
        testCar.addDistance(1);

        Assertions.assertThat(testCar.getDistance()).isEqualTo(1);
    }

    @Test
    void 조건에_맞게_자동차_이동_테스트() {
        Car testCar = new Car("승호");

        if (generateRandomNumber() >= 4) {
            Assertions.assertThat(testCar.getDistance()).isEqualTo(1);
        } else {
            Assertions.assertThat(testCar.getDistance()).isEqualTo(0);
        }
    }

}
