package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    private RacingCars racingCars;
    private List<RacingCar> carList;
    private static final String CAR1_NAME = "pobi";
    private static final String CAR2_NAME = "woni";
    private static final String CAR3_NAME = "jun";

    @BeforeEach
    void setUp() {
        RacingCar car1 = new RacingCar(CAR1_NAME);
        RacingCar car2 = new RacingCar(CAR2_NAME);
        RacingCar car3 = new RacingCar(CAR3_NAME);
        carList = Arrays.asList(car1, car2, car3);
        racingCars = new RacingCars(carList);
    }

    @Test
    void 자동차_3대가_RacingCars에_포함() {
        assertThat(racingCars.getRacingCars().size()).isEqualTo(3);
        assertThat(racingCars.getRacingCars())
                .extracting("name")
                .contains(CAR1_NAME, CAR2_NAME, CAR3_NAME);
    }
}