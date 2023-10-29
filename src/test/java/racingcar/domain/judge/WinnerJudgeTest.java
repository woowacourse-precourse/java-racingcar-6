package racingcar.domain.judge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
import racingcar.domain.car.ForwardCount;

class WinnerJudgeTest {

    @DisplayName("가장 많이 전진한 차가 우승자이다.")
    @Test
    void judge() {
        // given
        Cars raceFinishedCars = new Cars(List.of(
                Car.of(new CarName("haero77"), ForwardCount.from(3L)),
                Car.of(new CarName("pobi"), ForwardCount.from(0L)))
        );

        WinnerJudge judge = new WinnerJudge(raceFinishedCars);

        // when
        WinnerCars winnerCars = judge.judge();

        // then
        assertThat(winnerCars.getCars())
                .hasSize(1)
                .extracting("name", "forwardCount")
                .containsOnly(tuple("haero77", 3L));
    }

    @DisplayName("가장 많이 전진한 차의 개수가 복수라면, 해당 차 모두 우승자이다.")
    @Test
    void judge2() {
        // given
        Cars raceFinishedCars = new Cars(List.of(
                Car.of(new CarName("haero77"), ForwardCount.from(3L)),
                Car.of(new CarName("pobi"), ForwardCount.from(3L)))
        );

        WinnerJudge judge = new WinnerJudge(raceFinishedCars);

        // when
        WinnerCars winnerCars = judge.judge();

        // then
        assertThat(winnerCars.getCars())
                .hasSize(2)
                .extracting("name", "forwardCount")
                .containsExactlyInAnyOrder(
                        tuple("haero77", 3L),
                        tuple("pobi", 3L)
                );
    }

}