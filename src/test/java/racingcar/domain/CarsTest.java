package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarsTest {

    @Test
    @DisplayName("Cars의 우승자를 찾을 수 있다.")
    void findWinnersTest() {
        // given
        Car pobi = new Car(new Name("pobi"), new Position(4));
        Car woni = new Car(new Name("woni"), new Position(2));
        Cars cars = new Cars(List.of(pobi, woni));

        // when
        Names winners = cars.findWinners();

        // then
        assertThat(winners.value()).containsExactly(new Name("pobi"));
    }

    @Test
    @DisplayName("우승자가 두명일 경우 두명의 우승자를 찾을 수 있다.")
    void findTwoWinners() {
        // given
        Car pobi = new Car(new Name("pobi"), new Position(4));
        Car woni = new Car(new Name("woni"), new Position(4));
        Cars cars = new Cars(List.of(pobi, woni));

        // when
        Names winners = cars.findWinners();

        // then
        assertAll(
                () -> assertThat(winners.value()).hasSize(2),
                () -> assertThat(winners.value()).containsExactly(new Name("pobi"), new Name("woni"))
        );
    }

    @Test
    @DisplayName("한 라운드의 결과를 찾을 수 있다.")
    void findSingleRoundResult() {
        // given
        Car pobi = new Car(new Name("pobi"), new Position(4));
        Car woni = new Car(new Name("woni"), new Position(4));
        Cars cars = new Cars(List.of(pobi, woni));

        // when
        String singleRoundResult = cars.getSingleRoundResult();

        // then
        assertThat(singleRoundResult).isEqualTo("pobi : ----\nwoni : ----\n");
    }
}
