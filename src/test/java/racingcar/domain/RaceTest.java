package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Race 클래스")
class RaceTest {

    private Cars cars;
    private Try tryCount;
    private Race race;

    @BeforeEach
    void setup() {
        cars = new Cars(Arrays.asList("pobi", "crong", "jun"));
        tryCount = new Try(5);
        race = new Race(cars, tryCount);

    }

    @Test
    void 레이스_종료_시_우승자가_존재() {
        // when
        while (!race.isOver()) {
            race.doRace();
        }

        // then
        List<String> winners = race.findWinners();
        assertThat(winners).isNotNull();
        assertThat(winners.size()).isGreaterThan(0);
    }

    @Test
    void 레이스_후_시도_횟수가_1_차감() {
        race.doRace();
        assertThat(tryCount.getCount()).isEqualTo(4);
    }

}