package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @DisplayName("자동차명 리스트가 입력되면 모든 자동차가 추가되어야한다.")
    @Test
    void addCarsTest() {
        // Given
        cars.addCars(Arrays.asList("pobi", "woni", "jun"));

        // When
        HashMap<String, Integer> carPositions = cars.getCars();

        // Then
        assertThat(carPositions).hasSize(3);
        assertThat(carPositions.get("pobi")).isEqualTo(0);
        assertThat(carPositions.get("woni")).isEqualTo(0);
        assertThat(carPositions.get("jun")).isEqualTo(0);
    }

    @DisplayName("특정 자동차를 이동시키면 값이 1증가해야 한다.")
    @Test
    void moveCarTest() {
        // Given
        cars.addCars(Arrays.asList("pobi", "woni", "jun"));
        String carName = "pobi";

        // When
        cars.moveCar(carName);
        HashMap<String, Integer> carPositions = cars.getCars();

        // Then
        assertThat(carPositions.get("pobi")).isEqualTo(1);
        assertThat(carPositions.get("woni")).isEqualTo(0);
        assertThat(carPositions.get("jun")).isEqualTo(0);
    }

    @DisplayName("값이 같다면, 해당 차량은 모두 우승자로 결정되어야 한다.")
    @Test
    void determineMultipleWinnersTest() {
        // Given
        cars.addCars(Arrays.asList("pobi", "woni", "jun"));
        cars.moveCar("pobi");
        cars.moveCar("woni");

        // When
        var winners = cars.determineFinalWinner();

        // Then
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }

    @Test
    @DisplayName("가장 큰 값을 가진 자동차들이 우승자로 결정되어야 한다.")
    void determineFinalWinnerTest() {
        // Given
        cars.addCars(Arrays.asList("pobi", "woni", "jun"));
        cars.moveCar("pobi");
        cars.moveCar("pobi");
        cars.moveCar("jun");

        // When
        var winners = cars.determineFinalWinner();

        // Then
        assertThat(winners).containsExactlyInAnyOrder("pobi");
    }

}
