package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingManagerTest {
    @Test
    void 레이싱1회를_할_경우_결과_출력(){
        // Arrange
        RacingCar racingCar = new RacingCar("phobi");
        RacingManager racingManager = new RacingManager();
        racingManager.setLap(1);
        // Action, Assert
        assertThat(racingCar.move(5)).isEqualTo("phobi : -");
    }
}
