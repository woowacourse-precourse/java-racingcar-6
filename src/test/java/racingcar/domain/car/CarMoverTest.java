package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.Car;

class CarMoverTest {

    CarInfo carInfo = CarInfo.getInstance();
    Car car = new Car("ddong", 1);

    @DisplayName("자동차는 정의된 값(현재는 1)만큼 전진한 수 있다.")
    @Test
    void moveForward_전진() {
        //given
        carInfo.saveCarInfo(car);
        CarMover carMover = new CarMover(car);

        //when
        carMover.moveForward();
        Car updatedCar = carInfo.getCarInfo("ddong");

        //then
        assertThat(updatedCar.position()).isEqualTo(2);
    }
}