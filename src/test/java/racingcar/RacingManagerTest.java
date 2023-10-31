package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void 최종_우승자가_2명인_경우_우승자_출력(){
        // Arrange
        RacingCar racingCar1 = new RacingCar("phobi");
        RacingCar racingCar2 = new RacingCar("woni");
        RacingManager racingManager = new RacingManager();
        racingManager.setLap(1);

        // Action
        racingCar1.move(5); // 1칸 이동
        racingCar2.move(5); // 1칸 이동
        String result = racingManager.finalWinner(List.of(racingCar1, racingCar2));

        // Assert
        assertThat(result).isEqualTo("phobi, woni");
    }
}
