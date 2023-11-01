package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarsTest {

    @DisplayName("자동차가 2대 미만일 경우 예외가 발생한다.")
    @Test
    void minSizeCarsEx() {
        assertThatThrownBy(() -> RacingCars.from("one"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가장 많이 이동한 자동차가 최종 우승자가 된다.")
    @Test
    void findWinners() {
        //given
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        RacingCars racingCars = new RacingCars(List.of(pobiCar, woniCar));

        pobiCar.move(4);

        //when
        List<String> winners = racingCars.findWinners();

        //then
        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly(pobiCar.getName());
    }
}
