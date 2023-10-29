package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCountControllerTest {

    @Test
    @DisplayName("입력받은 회수를 숫자로 변경")
    public void makeRacingCount() {
        //given
        String inputRacingCount = "100";

        //when
        int result = RacingCountController.makeRacingCount(inputRacingCount);

        //then
        assertThat(result).isEqualTo(100);
    }

    @Test
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