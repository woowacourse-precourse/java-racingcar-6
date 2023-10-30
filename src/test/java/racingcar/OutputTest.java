package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
     void printCarNameInputRequestTest() {
        printCarNameInputRequest();
        assertThat(output.toString()).isEqualTo(CAR_NAME_INPUT_REQUEST_MESSAGE + lineSeparator);
    }

    @Test
    void printTryNumberInputRequestTest() {
        printTryNumberInputRequest();
        assertThat(output.toString()).isEqualTo(TRY_NUMBER_INPUT_REQUEST_MESSAGE + lineSeparator);
    }
    @Test
    void printResultTitleTest() {
        printResultTitle();
        assertThat(output.toString()).isEqualTo(RESULT_TITLE + lineSeparator);
    }
    @Test
    void printRacingMapTest() {
        LinkedHashMap racingMap = new LinkedHashMap<String, Integer>();
        racingMap.put("car1", 3);
        racingMap.put("car2", 5);
        racingMap.put("car3", 1);
        printRacingMap(racingMap);
        String answer = "car1 : ---" + lineSeparator + "car2 : -----" + lineSeparator + "car3 : -" + lineSeparator + lineSeparator;
        assertThat(output.toString()).isEqualTo((answer));
    }
}
