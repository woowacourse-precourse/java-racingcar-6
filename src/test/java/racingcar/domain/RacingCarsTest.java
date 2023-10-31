package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @Test
    @DisplayName("자동차들 중 가장 먼 거리 계산에 대한 예외 처리")
    void Given_RacingCars_When_RacingCarsMoved_Then_CalculatedFarthestIsSameAsTheFarthest() {
        // given
        RacingCars racingCars = new RacingCars();
        racingCars.add(new RacingCar("a"));
        racingCars.add(new RacingCar("b"));
        racingCars.add(new RacingCar("c"));
        final int farthest = 10;
        // when
        for (int i = 0; i < 5; i++) {
            racingCars.get(1).move();
        }
        for (int i = 0; i < farthest; i++) {
            racingCars.get(2).move();
        }

        // then
        assertThat(racingCars.farthestDistance()).isEqualTo(farthest);
    }
}