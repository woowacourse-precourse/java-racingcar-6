package racingcar.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceResultTest {
    @Test
    @DisplayName("getWinnerNames는 우승자가 한 명일 경우 해당 우승자의 이름만 반환한다.")
    void getWinnerNames_OneWinner() {
        // given
        List<Car> winner = List.of(
                new Car("car1", () -> true)
        );

        // when
        RaceResult raceResult = new RaceResult(winner);

        // then
        assertThat(raceResult.getWinnerNames()).isEqualTo("car1");
    }

    @Test
    @DisplayName("getWinnerNames는 우승자가 여럿일 경우 이름을 쉼표로 구분하여 반환한다.")
    void getWinnerNames_Multiple_Winner() {
        // given
        List<Car> winner = List.of(
                new Car("car1", () -> true),
                new Car("car2", () -> true),
                new Car("car3", () -> true)
        );

        // when
        RaceResult raceResult = new RaceResult(winner);

        // then
        assertThat(raceResult.getWinnerNames()).isEqualTo("car1, car2, car3");
    }
}