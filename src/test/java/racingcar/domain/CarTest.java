package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 객체 생성")
    public void createCarInstance() {
        // given
        String testCar = "phobi";
        // when
        Car car = Car.createCar(testCar);
        // then
        assertThat(car).isNotNull();
        assertThat(car).isInstanceOf(Car.class);

    }
}