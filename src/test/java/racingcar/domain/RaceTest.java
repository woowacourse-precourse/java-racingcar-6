package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class RaceTest {

    private static Race getTestRace(Integer number1, Integer number2, String countInput) {
        List<Integer> numbers = List.of(number1, number2);
        NumberGenerator numberGenerator = new TestNumberGenerator(numbers);
        Cars cars = new Cars(List.of("car1", "car2"));
        Count count = new Count(countInput);
        return new Race(cars, count, numberGenerator);
    }

    @ParameterizedTest
    @CsvSource({"3, 4, 0, 1", "4, 5, 1, 1"})
    @DisplayName("경주가 시작되면, 자동차들은 전진하고, 시도 횟수가 줄어든다")
    void play(Integer number1, Integer number2,
              Integer distance1, Integer distance2) {
        Race race = getTestRace(number1, number2, "1");

        race.run();

        assertThat(race.getCars().getCarList())
                .extracting(Car::getDistance)
                .containsExactly(distance1, distance2);

        assertThat(race.playable()).isFalse();
    }

    @ParameterizedTest
    @CsvSource({"1, true", "0, false"})
    @DisplayName("시도 횟수에 따라 경주가 가능한지 여부를 판단한다.")
    void playable(String countInput, boolean isPlayable) {
        Race race = getTestRace(3, 4, countInput);

        assertThat(race.playable()).isEqualTo(isPlayable);
    }

    @Test
    @DisplayName("경기 최종 우승자를 찾는다.")
    void findWinners() {
        Race race = getTestRace(3, 4, "1");
        race.run();
        assertThat(race.findWinners()).containsExactly("car2");

    }
}