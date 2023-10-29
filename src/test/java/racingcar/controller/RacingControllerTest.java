package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

class RacingControllerTest {

    @Test
    @DisplayName("랜덤한 수별로 이동 처리하기")
    public void testManageCarMovement() {
        // Given
        RacingController controller = new RacingController();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");

        // When
        controller.manageCarMovement(car1, 4); // move
        controller.manageCarMovement(car2, 3); // stop

        // Then
        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(0);
    }
}