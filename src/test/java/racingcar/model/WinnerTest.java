package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;

class WinnerTest {
    @Test
    void 우승자_이름_출력() {
        // given
        Winner winner = new Winner();
        List<Car> raceResult = Arrays.asList(new Car("car1",2),
                new Car("car2",0), new Car("car3", 3));

        // when
        String winnerResult = winner.selectWinner(new Cars(raceResult));

        // then
        assertThat(winnerResult).isEqualTo("car3");
    }

}