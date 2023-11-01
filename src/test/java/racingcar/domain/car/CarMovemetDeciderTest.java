package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.Car;

class CarMovemetDeciderTest {
    Car testCar = new Car("soddong", 0);
    CarInfo carInfo;

    @BeforeEach
    void clear() {
        carInfo = CarInfo.getInstance(); // CarInfo의 새 인스턴스를 생성하는 메서드
        carInfo.reset();
    }

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