package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

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
        RacingCar racingCar0 = new RacingCar("racingCar0", () -> true);
        RacingCar racingCar1 = new RacingCar("racingCar1", () -> true);
        RacingCar racingCar2 = new RacingCar("racingCar2", () -> false);

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
        RacingCar racingCar0 = new RacingCar("racingCar0", () -> true);
        RacingCar racingCar1 = new RacingCar("racingCar1", () -> true);
        RacingCar racingCar2 = new RacingCar("racingCar2", () -> false);

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
        RacingCar winner0 = new RacingCar("winner0", () -> true);
        RacingCar winner1 = new RacingCar("winner1", () -> true);
        RacingCar racingCar0 = new RacingCar("racingCar0", () -> false);

        winner0.race();
        winner1.race();

        RacingCars racingCars = new RacingCars(List.of(winner0, racingCar0, winner1));
        racingCars.printWinnersName();

        assertThat(output.toString().trim()).isEqualTo("winner0, winner1");
    }
}
