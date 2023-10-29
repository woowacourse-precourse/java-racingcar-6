package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {
    private final List<String> carNames = Arrays.asList("benz", "audi", "fox", "tesla");

    private Cars createCarsWithSpecificMoves(List<String> carNamesToMove, int moveValue) {
        List<Car> movedCars = carNames.stream()
            .map(Car::from)
            .map(car -> carNamesToMove.contains(car.getName()) ? car.move(moveValue) : car)
            .toList();

        return Cars.from(movedCars);
    }

    @Test
    void getWinner_아무도_앞으로_가지_못하면_전부_우승() {
        Cars cars = Cars.from(carNames.stream()
            .map(Car::from)
            .toList());
        assertThat(cars.getWinner().size()).isEqualTo(carNames.size());
    }

    @Test
    void getWinner_benz_audi_공동_우승() {
        Cars cars = createCarsWithSpecificMoves(List.of("benz", "audi"), 5);
        assertThat(cars.getWinner()).contains("benz", "audi");
    }

    @Test
    void getWinner_benz_우승() {
        Cars cars = createCarsWithSpecificMoves(List.of("benz"), 5);
        assertThat(cars.getWinner()).containsExactly("benz");
    }
}