package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameDisplayTest {

    private final PrintStream originalSystemOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalSystemOut);
    }

    @Test
    void displayRaceStatus_자동차_경주_상태_출력() {
        RacingCar car1 = new RacingCar("car1");
        RacingCar car2 = new RacingCar("car2");
        List<RacingCar> racingCars = Arrays.asList(car1, car2);

        car1.move();
        car2.move();
        car2.move();

        RacingGameDisplay.displayRaceStatus(racingCars);

        String expectedOutput = "car1 : -\n" +
                "car2 : --\n" +
                "\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void showWinners_우승자_출력() {
        List<String> winners = Arrays.asList("car1", "car2");

        RacingGameDisplay.showWinners(winners);

        String expectedOutput = "최종 우승자 : car1, car2\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
