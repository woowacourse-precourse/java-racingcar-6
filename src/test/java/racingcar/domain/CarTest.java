package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("차를 생성하는 기능 확인")
    void createCar() {
        String carName = "abc";

        Car createdCar = Car.createCar(carName);

        assertThat(createdCar).isNotNull();
        assertThat(createdCar).isExactlyInstanceOf(Car.class);
    }
}