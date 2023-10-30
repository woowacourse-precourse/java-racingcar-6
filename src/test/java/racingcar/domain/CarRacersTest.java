package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarRacersTest {

    @Test
    void 자동차_레이서들이_조건을_따라_1회_움직이면_자동차의_거리가_변한다() {
        // given
        List<Car> racers = List.of(
                new Car("one", () -> true),
                new Car("two", () -> true)
        );
        CarRacers expectedCarRacers = new CarRacers(racers);
        // when
        List<Car> actualRaces = expectedCarRacers.raceOfOneCycle();
        // then
        assertAll(
                () -> assertThat(actualRaces.get(0).getMovementDistance()).isEqualTo(1),
                () -> assertThat(actualRaces.get(1).getMovementDistance()).isEqualTo(1)
        );
    }

    @Test
    void 자동차_레이서_중에서_가장_많이_움직인_자동차의_이름을_얻을_수_있다() {
        // given
        List<Car> racers = List.of(
                new Car("one", () -> true),
                new Car("two", () -> false)
        );
        CarRacers expectedCarRacers = new CarRacers(racers);
        // when
        expectedCarRacers.raceOfOneCycle();
        List<String> actualRacers = expectedCarRacers.getMostMovementCarNames();
        // then
        assertAll(
                () -> assertThat(actualRacers.size()).isEqualTo(1),
                () -> assertThat(actualRacers.get(0)).isEqualTo("one")
        );
    }

    @Test
    void 레이서_목록이_비어있는_경우_가장_많이_움직인_자동차_이름을_조회하면_예외가_발생한다() {
        // given
        List<Car> racers = List.of();
        CarRacers expectedCarRacers = new CarRacers(racers);
        // when
        // then
        assertThatThrownBy(expectedCarRacers::getMostMovementCarNames)
              .isInstanceOf(IllegalStateException.class)
              .hasMessage("racers is empty");
    }
}