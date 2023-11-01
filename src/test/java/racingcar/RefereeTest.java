package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RefereeTest {
    Referee referee = new Referee();

    @Test
    void 심판이_자동차가_정지하도록_판단한_경우() {
        final int LOWER_NUMBER_THAN_FOUR = 3;

        Assertions.assertThat(referee.judgeMoveOrStop(LOWER_NUMBER_THAN_FOUR)).isEqualTo(false);
    }

    @Test
    void 심판이_자동차가_전진하도록_판단한_경우() {
        final int HIGHER_NUMBER_THAN_FOUR = 5;

        Assertions.assertThat(referee.judgeMoveOrStop(HIGHER_NUMBER_THAN_FOUR)).isEqualTo(true);
    }

    @Test
    void 경주_우승자가_1명인_경우() {
        List<Car> cars = new ArrayList<>();
        int max = 3;

        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));

        cars.get(0).moveOrStop(true);
        cars.get(0).moveOrStop(true);
        cars.get(0).moveOrStop(true);

        cars.get(1).moveOrStop(true);
        cars.get(1).moveOrStop(true);

        cars.get(2).moveOrStop(true);

        Assertions.assertThat(referee.judgeWinners(cars, max).get(0)).isEqualTo("a");
    }


}
