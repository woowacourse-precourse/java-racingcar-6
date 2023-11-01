package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {


    @Test
    @DisplayName("레이싱은 주어진 라운드만큼 돈다")
    void racing_run_round_that_given() {
        Car winner = new Car("win", () -> true);
        Racing racing = new Racing(List.of(winner), 5);
        List<RacingRoundResult> racingResult = racing.race();
        assertThat(racingResult).hasSize(5);
    }

    @Test
    @DisplayName("레이싱은 라운드마다 자동차들을 전진시킨다")
    void racing_move_car_every_round() {
        Car winner = new Car("win", () -> true);
        Racing racing = new Racing(List.of(winner), 5);
        racing.race();
        assertThat(winner.getCurrentStatus().position()).isEqualTo(5);
    }

    @Test
    @DisplayName("레이싱은 라운드마다 자동차들의 이동 상태를 기록한다")
    void racing_record_car_move_every_round() {
        String winnerName = "win";
        String loserName = "lose";
        Car winner = new Car(winnerName, () -> true);
        Car loser = new Car(loserName, () -> false);
        Racing racing = new Racing(List.of(winner, loser), 5);
        List<RacingRoundResult> racingResult = racing.race();

        CarStatus loserStatus = new CarStatus(loserName, 0);
        assertThat(racingResult).isEqualTo(List.of(
                new RacingRoundResult(List.of(new CarStatus(winnerName, 1), loserStatus)),
                new RacingRoundResult(List.of(new CarStatus(winnerName, 2), loserStatus)),
                new RacingRoundResult(List.of(new CarStatus(winnerName, 3), loserStatus)),
                new RacingRoundResult(List.of(new CarStatus(winnerName, 4), loserStatus)),
                new RacingRoundResult(List.of(new CarStatus(winnerName, 5), loserStatus))
        ));
    }
}
