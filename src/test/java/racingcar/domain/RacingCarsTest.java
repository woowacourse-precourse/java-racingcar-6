package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    private RacingCars racingCars;
    private List<String> racingCarNames;
    private static final String CAR1_NAME = "pobi";
    private static final String CAR2_NAME = "woni";
    private static final String CAR3_NAME = "jun";

    @BeforeEach
    void setUp() {
        racingCarNames = Arrays.asList(CAR1_NAME, CAR2_NAME, CAR3_NAME);
        racingCars = new RacingCars(racingCarNames);
    }

    @Test
    void 자동차_3대가_RacingCars에_포함() {
        assertThat(racingCars.getRacingCars().size()).isEqualTo(3);
        assertThat(racingCars.getRacingCars())
                .extracting("name")
                .contains(CAR1_NAME, CAR2_NAME, CAR3_NAME);
    }
}