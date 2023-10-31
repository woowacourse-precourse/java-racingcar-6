package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car 테스트")
public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("Car 객체 생성 테스트")
    @Test
    void createCar() {
        CarName carName = new CarName("Car1");
        Car car = new Car(carName);
        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo("Car1");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("Car 객체 이동 테스트")
    @Test
    void moveCar() {
        CarName carName = new CarName("Car2");
        Car car = new Car(carName);

        // 이동하지 않는 경우
        car.moveToCar(STOP);
        assertThat(car.getPosition()).isEqualTo(0);

        // 이동하는 경우
        car.moveToCar(MOVING_FORWARD);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
