package racingcar.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RacingTest {

    private final int roundNumber = 5;
    private Car moveEveryTimeCar;
    private Car stoppedCar;
    private Racing racing;

    @BeforeEach
    void setUp() {
        moveEveryTimeCar = new Car("move", () -> true);
        stoppedCar = new Car("stop", () -> false);
        racing = new Racing(List.of(moveEveryTimeCar, stoppedCar), roundNumber);
    }

    @Test
    @DisplayName("레이싱은 주어진 라운드만큼 돈다")
    void racing_run_round_that_given() {
        RacingResult racingResult = racing.race();
        assertThat(racingResult.racingRoundResults()).hasSize(roundNumber);
    }

    @Test
    @DisplayName("레이싱은 라운드마다 자동차들을 전진시킨다")
    void racing_move_car_every_round() {
        racing.race();
        assertThat(moveEveryTimeCar.getCurrentStatus().position()).isEqualTo(5);
    }

    @Test
    @DisplayName("레이싱은 라운드마다 자동차들의 이동 상태를 기록한다")
    void racing_record_car_move_every_round() {
        RacingResult racingResult = racing.race();
        String moveCarName = moveEveryTimeCar.getName();
        CarStatus stopCarStatus = new CarStatus(stoppedCar.getName(), 0);
        assertThat(racingResult.racingRoundResults()).isEqualTo(List.of(
                new RacingRoundResult(List.of(new CarStatus(moveCarName, 1), stopCarStatus)),
                new RacingRoundResult(List.of(new CarStatus(moveCarName, 2), stopCarStatus)),
                new RacingRoundResult(List.of(new CarStatus(moveCarName, 3), stopCarStatus)),
                new RacingRoundResult(List.of(new CarStatus(moveCarName, 4), stopCarStatus)),
                new RacingRoundResult(List.of(new CarStatus(moveCarName, 5), stopCarStatus))
        ));
    }

    @Test
    @DisplayName("레이싱이 끝난 후 가장 앞선 사람이 우승자다")
    void racing_winner() {
        RacingResult racingResult = racing.race();
        assertThat(racingResult.winnerNames()).isEqualTo(List.of(moveEveryTimeCar.getName()));
    }

    @Test
    @DisplayName("레이싱이 끝난 후 가장 앞선 사람이 여러명이면 모두 우승자다")
    void racing_multiple_winners() {
        String winnerName = "win";
        String anotherWinnerName = "win2";
        Car winner = new Car(winnerName, () -> true);
        Car anotherWinner = new Car(anotherWinnerName, () -> true);
        Racing racing = new Racing(List.of(winner, anotherWinner), 5);
        RacingResult racingResult = racing.race();

        assertThat(racingResult.winnerNames()).isEqualTo(List.of(winnerName, anotherWinnerName));
    }

    @Test
    @DisplayName("레이싱은 자동차 이름이 중복되는 경우 예외를 던진다")
    void racing_throw_exception_when_duplicate_car_name() {
        String duplicateName = "dup";
        Car car = new Car(duplicateName, () -> true);
        Car duplicateNameCar = new Car(duplicateName, () -> true);
        assertThatThrownBy(() -> new Racing(List.of(car, duplicateNameCar), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("레이싱은 라운드가 0 이하인 경우 예외를 던진다")
    void racing_throw_exception_when_round_number_is_zero_or_negative() {
        assertThatThrownBy(() -> new Racing(List.of(moveEveryTimeCar, stoppedCar), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
