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
        final String expectedName = "다나카";
        final List<Car> cars = List.of(
                new Car(expectedName, 3),
                new Car("트럼프", 2));

        // When
        final List<String> result = raceSteward.nominateWinners(CarList.of(cars));

        // Then
        assertThat(result).isNotEmpty();
        assertThat(result).contains(expectedName);
    }

}