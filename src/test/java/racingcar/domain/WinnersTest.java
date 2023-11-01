package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    @DisplayName("두 자동차의 위치가 다르면 우승자 1명")
    void When_TwoPositionsAreDifferent_Expect_1Winners() {
        // given
        List<Car> cars = new ArrayList<>();
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        cars.add(pobiCar);
        cars.add(woniCar);

        // when
        int goRandomNumber = 4;
        int stopRandomNumber = 3;
        pobiCar.MoveOrStop(goRandomNumber);
        woniCar.MoveOrStop(stopRandomNumber);

        Winners winners = new Winners(cars);

        // then
        assertThat(winners.getWinners().size()).isEqualTo(1);
        assertThat(winners.getWinners().contains(pobiCar));
    }

    @Test
    @DisplayName("두 자동차의 위치가 같으면 우승자 2명")
    void When_TwoPositionsAreSame_Expect_2Winners() {
        // given
        List<Car> cars = new ArrayList<>();
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        cars.add(pobiCar);
        cars.add(woniCar);

        // when
        int goRandomNumber = 4;
        int stopRandomNumber = 5;
        pobiCar.MoveOrStop(goRandomNumber);
        woniCar.MoveOrStop(stopRandomNumber);

        Winners winners = new Winners(cars);

        // then
        assertThat(winners.getWinners().size()).isEqualTo(2);
        assertThat(winners.getWinners().contains(pobiCar));
        assertThat(winners.getWinners().contains(woniCar));
    }
}
