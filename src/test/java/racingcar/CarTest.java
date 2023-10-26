package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    @DisplayName("자동차 운전 테스트")
    @Test
    void driveTest() {
        // given
        String carName = "홍길동";
        Car car = new Car(carName);

        // when
        int location = car.randomDrive();

        // then
        assertThat(location).isGreaterThan(0);
    }
}
