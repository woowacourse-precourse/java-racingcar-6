package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("[Car] Car 생성")
    void createCarTest() {
        // Given
        String carName = "pobi";

        // When
        Car car = new Car(carName);

        // Then
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
