package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;

public class CarsTest {

    List<String> names;

    @BeforeEach
    void setUp() {
        names = List.of("pobi", "crong", "honux");
    }

    @Test
    void createCars() {
        Cars cars = Cars.of(names);
        assertThat(cars.get()).isEqualTo(List.of(
                Car.of("pobi", 0),
                Car.of("crong", 0),
                Car.of("honux", 0)
        ));
    }

    @Test
    void race() {
        Cars cars = Cars.of(names);
        NumberGenerator numberGenerator = () -> 4;

        List<Car> racedCars = cars.race(numberGenerator);
        assertThat(racedCars).isEqualTo(
                List.of(
                        Car.of("pobi", 1),
                        Car.of("crong", 1),
                        Car.of("honux", 1)
                )
        );
    }

    @Test
    void getWinnerNames() {
        Cars cars = Cars.of(names);
        List<Car> carList = cars.get();

        carList.get(0).move(4);
        carList.get(1).move(4);
        carList.get(2).move(3);

        List<String> winnerNames = cars.getWinnerNames();
        List<String> expect = List.of("pobi", "crong");

        assertThat(winnerNames).isEqualTo(expect);
    }

}
