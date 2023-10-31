package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;
    private List<String> racingCarNames;
    private static final String CAR1_NAME = "pobi";
    private static final String CAR2_NAME = "woni";
    private static final String CAR3_NAME = "jun";

    @BeforeEach
    void setUp() {
        racingCarNames = Arrays.asList(CAR1_NAME, CAR2_NAME, CAR3_NAME);
        cars = new Cars(racingCarNames);
    }

    @Test
    void 자동차_3대가_RacingCars에_포함() {
        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars())
                .extracting("name")
                .contains(CAR1_NAME, CAR2_NAME, CAR3_NAME);
    }
}