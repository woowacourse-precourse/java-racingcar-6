package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RoundTest {

    private Round round;
    private NumberGenerator numberGenerator;
    private RacingCars racingCars;
    private static final String CAR1_NAME = "pobi";
    private static final String CAR2_NAME = "woni";
    private static final String CAR3_NAME = "jun";
    private RacingCar car1;
    private RacingCar car2;
    private RacingCar car3;

    @BeforeEach
    void setUp() {
        numberGenerator = mock(NumberGenerator.class);
        round = new Round(racingCars, numberGenerator, new ForwardChecker());
        car1 = new RacingCar(CAR1_NAME);
        car2 = new RacingCar(CAR2_NAME);
        car3 = new RacingCar(CAR3_NAME);
        List<RacingCar> carList = Arrays.asList(car1, car2, car3);
        racingCars = new RacingCars(carList);
    }

    @Test
    void run_메서드으로_각_차수마다_RacingCars의_자동차들을_자동차_전진조건을_판단해서_전진() {
        when(numberGenerator.createRandomNumber())
                .thenReturn(4)
                .thenReturn(3)
                .thenReturn(5);

        round.run(racingCars);
        assertThat(car1.getForwardDistance()).isEqualTo(1);
        assertThat(car2.getForwardDistance()).isEqualTo(0);
        assertThat(car3.getForwardDistance()).isEqualTo(1);
    }
}