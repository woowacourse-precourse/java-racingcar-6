package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.mock.FakeMovingStrategy.ALWAYS_MOVING_STRATEGY;
import static racingcar.mock.FakeMovingStrategy.NEVER_MOVING_STRATEGY;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void readyToOutputTest() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void resetOutput() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void RacingCars는_자동차들을_진행시킬_수_있다() {
        RacingCar racingCar0 = new RacingCar("racingCar0", ALWAYS_MOVING_STRATEGY);
        RacingCar racingCar1 = new RacingCar("racingCar1", ALWAYS_MOVING_STRATEGY);
        RacingCar racingCar2 = new RacingCar("racingCar2", NEVER_MOVING_STRATEGY);

        RacingCars racingCars = new RacingCars(List.of(racingCar0, racingCar1, racingCar2));
        racingCars.race();
        racingCars.printCarsPosition();

        String expectedCarPositions = """
            racingCar0 : -\r
            racingCar1 : -\r
            racingCar2 :""";
        assertThat(output.toString().trim()).isEqualTo(expectedCarPositions);
    }

    @Test
    void RacingCars는_자동차들의_진행상황을_출력할_수_있다() {
        RacingCar racingCar0 = new RacingCar("racingCar0", ALWAYS_MOVING_STRATEGY);
        RacingCar racingCar1 = new RacingCar("racingCar1", ALWAYS_MOVING_STRATEGY);
        RacingCar racingCar2 = new RacingCar("racingCar2", NEVER_MOVING_STRATEGY);

        racingCar0.race();
        racingCar0.race();
        racingCar1.race();

        RacingCars racingCars = new RacingCars(List.of(racingCar0, racingCar1, racingCar2));
        racingCars.printCarsPosition();

        String expectedCarPositions = """
            racingCar0 : --\r
            racingCar1 : -\r
            racingCar2 :""";
        assertThat(output.toString().trim()).contains(expectedCarPositions);
    }

    @Test
    void RacingCars는_우승자를_출력할_수_있다() {
        RacingCar winner0 = new RacingCar("winner0", ALWAYS_MOVING_STRATEGY);
        RacingCar winner1 = new RacingCar("winner1", ALWAYS_MOVING_STRATEGY);
        RacingCar racingCar0 = new RacingCar("racingCar0", NEVER_MOVING_STRATEGY);

        winner0.race();
        winner1.race();

        RacingCars racingCars = new RacingCars(List.of(winner0, racingCar0, winner1));
        racingCars.printWinnersName();

        assertThat(output.toString().trim()).isEqualTo("winner0, winner1");
    }
}
