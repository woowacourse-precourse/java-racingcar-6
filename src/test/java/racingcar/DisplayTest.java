package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;
import racingcar.View.OutputView;

public class DisplayTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void displayPositions() {
        List<Car> cars = Arrays.asList(
                new Car("pobi"),
                new Car("woni")
        );
        cars.get(0).carPosition = 3;
        cars.get(1).carPosition = 2;

        OutputView.displayPositions(cars);

        String expectedOutput =  "pobi : ---" + System.lineSeparator() +
        "woni : --" + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    public void displaySingleWinner() {
        List<String> winners = Arrays.asList("pobi");
        OutputView.displayWinners(winners);

        String expectedOutput = "최종 우승자: pobi"+ System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    public void displayMultipleWinners() {
        List<String> winners = Arrays.asList("pobi", "jun");
        OutputView.displayWinners(winners);

        String expectedOutput = "최종 우승자: pobi, jun"+ System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}
