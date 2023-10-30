package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("입력받은 이름으로 Car 객체를 생성한다.")
    void testCreateCar() {
        String name = "test";
        Car car = new Car(name);

        assertThat(name).isEqualTo(car.getName());
    }

    @Test
    @DisplayName("Car name의 길이는 1~5사이이다.")
    void testValidateCarNameLength() {
        String name = "testtest";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}