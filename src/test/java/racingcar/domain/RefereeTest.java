package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {
    @Test
    @DisplayName("충분히 시뮬레이션 돌렸을 때 모든 자동차의 거리가 1 이상인지 판단")
    void Given_RacingCars_When_RefereeSimulatedThousanTimes_Then_AllCarsMoved() {
        final int TEST_NUMBER = 10000;
        // given
        RacingCars racingCars = new RacingCars();
        for (int i = 0; i < TEST_NUMBER; i++) {
            racingCars.add(new RacingCar("test"));
        }
        // when
        for (int i = 0; i < TEST_NUMBER; i++) {
            Referee.simulate(racingCars);
        }

        // then
        for (int i = 0; i < TEST_NUMBER; i++) {
            assertThat(racingCars.get(1).getDistance()).isGreaterThan(0);
        }
    }

    @Test
    @DisplayName("우승자는 항상 1명 이상인지 판단")
    void Given_RacingCars_When_RefereeCalculatedWinner_Then_AtLeastOneWinner() {
        // given
        RacingCar racingCar1 = new RacingCar("test");
        RacingCar racingCar2 = new RacingCar("test");
        RacingCars racingCars = new RacingCars();
        racingCars.add(racingCar1);
        racingCars.add(racingCar2);
        // when
        RacingCars result = Referee.calculateWinners(racingCars);

        // then
        assertThat(result.size()).isGreaterThan(0);
    }
}