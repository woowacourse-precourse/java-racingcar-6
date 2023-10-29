package racingcar.domain.game;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;

public class WinnerTest {
    @DisplayName("가장 먼 거리를 이동한 위치를 반환해야 한다.")
    @Test
    void 최대_이동_거리_반환_테스트() {
        //given
        String name = "jun,pobi,woni";
        Cars cars = new Cars(name);
        List<Integer> numbers = List.of(5,0,0);
        List<Integer> number2 = List.of(6,9,8);

        //when
        Round round = new Round(numbers, cars);
        round.race();
        Round round2 = new Round(numbers, cars);
        round2.race();

        Winner winner = new Winner(cars);
        int maxPosition = winner.getMaxPosition(cars);

        //then
        assertThat(maxPosition).isEqualTo(2);
    }

    @DisplayName("가장 먼 거리를 이동한 자동차가 우승한다. (우승자가 한 명인 경우)")
    @Test
    void 우승자가_한_명인_경우_테스트() {
        //given
        String name = "jun,pobi,woni";
        Cars cars = new Cars(name);
        List<Integer> numbers = List.of(5,0,0);
        Round round = new Round(numbers, cars);

        //when
        round.race();
        Winner winner = new Winner(cars);

        //then
        assertThat(winner.toString()).isEqualTo("jun");
    }

    @DisplayName("가장 먼 거리를 이동한 자동차가 우승한다. (우승자가 여러 명인 경우)")
    @Test
    void 우승자가_여러_명인_경우_테스트() {
        //given
        String name = "jun,pobi,woni";
        Cars cars = new Cars(name);
        List<Integer> numbers = List.of(5,5,0);
        Round round = new Round(numbers, cars);

        //when
        round.race();
        Winner winner = new Winner(cars);

        //then
        assertThat(winner.toString()).isEqualTo("jun, pobi");
    }
}
