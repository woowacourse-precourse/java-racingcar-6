package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.vo.CarList;

class RaceStewardTest {

    private RaceSteward raceSteward;

    @BeforeEach
    void setUp() {
        raceSteward = new RaceSteward();
    }

    @Test
    @DisplayName("가장 전진한 칸이 많은 자동차를 우승자로 고른다.")
    void nominateWinners_BiggestForwardCount_Winner() {
        // Given
        Car danakaCar = new Car("다나카", 3);
        List<Car> cars = List.of(
                danakaCar,
                new Car("트럼프", 2));

        // When
        CarList result = raceSteward.nominateWinners(CarList.of(cars));

        // Then
        assertThat(result.isEmpty()).isFalse();
        assertThat(result.cars()).contains(danakaCar);
    }

}