package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarRaceTrackTest {

    @Test
    void 자동차_경주가_끝나면_가장_많이_움직인_자동차_이름을_반환_한다() {
        // given
        List<Car> racers = List.of(
                new Car("one", () -> true),
                new Car("two", () -> false)
        );
        CarRacers carRacers = new CarRacers(racers);
        CarRaceTrack expectedCarRaceTrack = new CarRaceTrack(carRacers);
        // when
        List<String> actualRaceTrack = expectedCarRaceTrack.race(3, car -> {});
        // then
        assertAll(
                () -> assertThat(actualRaceTrack.size()).isEqualTo(1),
                () -> assertThat(actualRaceTrack.get(0)).isEqualTo("one")
        );
    }
}