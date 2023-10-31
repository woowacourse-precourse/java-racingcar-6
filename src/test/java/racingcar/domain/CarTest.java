package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 생성")
    public void createCar() {
        String name = "test";
        Car car = new Car(name);

        assertThat(car).isNotNull();
    }
}