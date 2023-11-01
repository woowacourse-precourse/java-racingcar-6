package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("차량생성")
    @Test
    void createCar() {
        //given
        String carName = "YW";
        //when
        Car car = new Car(carName);
        //then
        Assertions.assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("차량 위치")
    @Test
    void checkPosition() {
        //given
        String carName = "YW";
        //when
        Car car = new Car(carName);
        //then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("차량 전진")
    @Test
    void moveForward() {
        //given
        String carName = "YW";
        Car car = new Car(carName);
        int position = car.getPosition();

        //when
        car.move(MOVING_FORWARD);

        //then
        Assertions.assertThat(car.getPosition()).isEqualTo(position + 1);
    }

    @DisplayName("차량 정지")
    @Test
    void stop() {
        //given
        String carName = "YW";
        Car car = new Car(carName);
        int position = car.getPosition();

        //when
        car.move(STOP);

        //then
        Assertions.assertThat(car.getPosition()).isEqualTo(position);
    }
}
