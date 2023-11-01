package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Race 클래스")
class RaceTest {

    @Test
    void 레이스_종료_시_우승자가_존재() {
        // given
        Cars cars = new Cars(Arrays.asList("pobi", "crong", "jun"));
        Try tryCount = new Try(5);
        Race race = new Race(cars, tryCount);

        // when
        while (!race.isOver()) {
            race.doRace();
        }

        // then
        List<String> winners = race.findWinners();
        assertThat(winners).isNotNull();
        assertThat(winners.size()).isGreaterThan(0);
    }

}