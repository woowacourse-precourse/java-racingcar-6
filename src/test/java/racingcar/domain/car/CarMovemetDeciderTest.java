package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.Car;

class CarMovemetDeciderTest {
    CarInfo carInfo = CarInfo.getInstance();
    Car testCar = new Car("soddong", 0);

    @DisplayName("움직임을 결정 할 수 있다.")
    @Test
    void decideMovement() {
        // given
        carInfo.saveCarInfo(testCar);
        CarMovementDecider carMovementDecider = new CarMovementDecider(testCar);

        // when
        carMovementDecider.decideMovement();

        // then
        Car updatedCar = carInfo.getCarInfo("soddong");
        assertThat(updatedCar.position()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
    }

}