package racingcar.domain;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static racingcar.domain.RacingCarGame.playRace;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.InputData;

class RacingCarGameTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testPlayRace() {
        InputData inputData = mock(InputData.class);
        when(inputData.getAttemptCount()).thenReturn("2");

        Car car = mock(Car.class);
        when(car.getCarName()).thenReturn(Arrays.asList("pobi", "woni"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        playRace(inputData, car);

        List<String> expectedLines = Arrays.asList(
                "pobi :",
                "woni :",
                "",
                "pobi :",
                "woni :");

        List<String> actualLines = new ArrayList<>(Arrays.asList(outputStream.toString().split("\\n")));
        List<String> extractedLines = new ArrayList<>();

        for (String line : actualLines) {
            int colonIndex = line.indexOf(":");

            String extracted = line.substring(0, colonIndex + 1);
            extractedLines.add(extracted);
        }

        Assertions.assertThat(extractedLines)
                .containsExactlyElementsOf(expectedLines);

        System.setOut(System.out);
    }
}