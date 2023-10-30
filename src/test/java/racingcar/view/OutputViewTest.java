package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private OutputView outputView;

    @BeforeEach
    public void setUpStreams() {
        outputView = new OutputView();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @DisplayName("실행결과 문구출력")
    @Test
    public void testPrintResultText() {
        outputView.printResultText();
        assertThat(outContent.toString()).isEqualTo("실행 결과\n");
    }

    @DisplayName("경주결과 정상출력 확인")
    @Test
    public void testPrintExecutionResult() {
        // Given
        LinkedHashMap<String, Integer> cars = new LinkedHashMap<>();
        cars.put("car1", 3);
        cars.put("car2", 2);

        // When
        outputView.printExecutionResult(cars);

        // Then
        String expectedOutput = "car1 : ---\n" + "car2 : --\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

}

