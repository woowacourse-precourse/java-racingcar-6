package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.model.Car;

public class OutputManagerTest {
    ByteArrayOutputStream outputStream;
    OutputManager outputManager;

    @BeforeEach
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputManager = new OutputManager();
    }

    @Test
    void printCarStatus_success() {
        // Given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 2));
        cars.add(new Car("woni", 4));
        cars.add(new Car("jun", 3));

        // When
        outputManager.printCarStatus(cars);
        System.setOut(System.out);

        // Then
        String actualOutput = outputStream.toString().trim();
        String expectedOutput = "pobi : --\n" +
                "woni : ----\n" +
                "jun : ---";
        expectedOutput = expectedOutput.replace("\n", System.lineSeparator());
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    void printWinners_success() {
        // Given
        List<Car> winners = new ArrayList<>();
        winners.add(new Car("pobi", 3));
        winners.add(new Car("woni", 3));

        // When
        outputManager.printWinners(winners);
        System.setOut(System.out);

        // Then
        String actualOutput = outputStream.toString().trim();
        String expectedOutput = "최종 우승자 : pobi, woni";
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}