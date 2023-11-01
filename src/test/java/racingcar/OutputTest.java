package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.Output.*;

public class OutputTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    String lineSeparator = System.lineSeparator();

    @BeforeEach
    public void setUpStreams() {
        System.setOut((new PrintStream(output)));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }
    @Test
     void canPrintCarNameInputRequest() {
        printCarNameInputRequest();
        assertThat(output.toString()).isEqualTo(CAR_NAME_INPUT_REQUEST_MESSAGE + lineSeparator);
    }

    @Test
    void canPrintTryNumberInputRequest() {
        printTryNumberInputRequest();
        assertThat(output.toString()).isEqualTo(TRY_NUMBER_INPUT_REQUEST_MESSAGE + lineSeparator);
    }

    @Test
    void canPrintResultTitle() {
        printResultTitle();
        assertThat(output.toString()).isEqualTo(RESULT_TITLE + lineSeparator);
    }

    @Test
    void canPrintRacingResult() {
        LinkedHashMap<String, Integer> racingMap = new LinkedHashMap<>();
        racingMap.put("car1", 3);
        racingMap.put("car2", 5);
        racingMap.put("car3", 1);
        printRacingMap(racingMap);
        String answer = "car1 : ---" + lineSeparator + "car2 : -----" + lineSeparator + "car3 : -" + lineSeparator + lineSeparator;
        assertThat(output.toString()).isEqualTo((answer));
    }

    @Test
    void canPrintWinners() {
        ArrayList<String> winners= new ArrayList<>(Arrays.asList("car1", "car2", "car3"));
        printWinners(winners);
        String answer = "최종 우승자 : car1, car2, car3";
        assertThat(output.toString()).isEqualTo(answer + lineSeparator);
    }
}
