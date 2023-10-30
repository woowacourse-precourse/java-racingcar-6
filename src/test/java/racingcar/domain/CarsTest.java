package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}
