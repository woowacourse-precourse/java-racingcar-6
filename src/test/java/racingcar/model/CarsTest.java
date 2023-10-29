package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @DisplayName("가장 멀리나간 자동차를 구하는 기능.")
    @Test
    void findWinningCars_가장_멀리나간_차들() {
        Car pobi = new Car(new Name("pobi"), new Position(2));
        Car woni = new Car(new Name("woni"), new Position(3));
        Car jun = new Car(new Name("jun"), new Position(1));
        Car ski = new Car(new Name("ski"), new Position(3));
        Cars cars = new Cars(Arrays.asList(pobi, woni, jun, ski));
        List<Car> expected = Arrays.asList(woni, ski);

        List<Car> winningCars = cars.findWinningCars();

        for (int index = 0; index < winningCars.size(); index++) {
            assertThat(winningCars.get(index)).isEqualTo(expected.get(index));
        }
    }
}
