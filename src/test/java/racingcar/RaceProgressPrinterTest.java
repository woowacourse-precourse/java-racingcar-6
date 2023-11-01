package racingcar;

import racingcar.controller.RaceProgressPrinter;
import racingcar.model.RacingCar;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.assertj.core.api.Assertions.assertThat;

public class RaceProgressPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    public void printRaceResult_ShouldPrintCarProgress_WhenGivenValidCarArray() {
        System.setOut(new PrintStream(outContent));
        RaceProgressPrinter printer = new RaceProgressPrinter();

        RacingCar car1 = new RacingCar("Car1");
        RacingCar car2 = new RacingCar("Car2");
        car1.move(2);
        car2.move(4);
        RacingCar[] cars = {car1, car2};

        printer.printRaceResult(cars);
        String expectedOutput = "Car1 : --\nCar2 : ----\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);

        System.setOut(originalOut);
    }
}