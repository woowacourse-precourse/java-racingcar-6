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
        assertThat(cars.get().size()).isEqualTo(3);
    }

}
