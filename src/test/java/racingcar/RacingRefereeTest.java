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

public class RacingRefereeTest {

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
    void 심판은_우승자를_가려내고_이름을_출력할_수_있다() {
        RacingCar winner = new RacingCar("winner", ALWAYS_MOVING_STRATEGY);
        RacingCar racingCar0 = new RacingCar("racingCar0", NEVER_MOVING_STRATEGY);
        RacingCar racingCar1 = new RacingCar("racingCar1", NEVER_MOVING_STRATEGY);

        winner.race();
        winner.race();
        winner.race();

        List<RacingCar> racingCars = List.of(winner, racingCar0, racingCar1);
        RacingReferee.printWinnersName(racingCars);

        assertThat(output.toString().trim()).isEqualTo("winner");
    }

    @Test
    void 심판은_공동_우승자를_가려내고_쉼표와_함께_출력할_수_있다() {
        RacingCar winner0 = new RacingCar("winner0", ALWAYS_MOVING_STRATEGY);
        RacingCar winner1 = new RacingCar("winner1", ALWAYS_MOVING_STRATEGY);
        RacingCar racingCar0 = new RacingCar("racingCar0", NEVER_MOVING_STRATEGY);

        winner0.race();
        winner1.race();

        List<RacingCar> racingCars = List.of(winner0, racingCar0, winner1);
        RacingReferee.printWinnersName(racingCars);

        assertThat(output.toString().trim()).isEqualTo("winner0, winner1");
    }
}
