package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @DisplayName("Car 생성 성공 테스트")
    @Test
    void createCarSuccessTest() {
        CarName carName = new CarName("김씨차");
        Car car = new Car(carName);

        assertThat(car.getCarName()).isEqualTo("김씨차");
        assertThat(car.getPosition()).isEqualTo(0);
    }
}