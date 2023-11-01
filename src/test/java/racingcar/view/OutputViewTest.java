package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {

    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(printStream);
    }

    @Test
    public void printExecutionResult_출력테스트() {
        OutputView outputView = new OutputView();
        outputView.printExecutionResult();

        assertEquals("\n실행 결과\r\n", outputStream.toString());
    }

    @Test
    public void printRacingCarStatus_출력테스트() {
        List<String> carStatus = new ArrayList<>();
        carStatus.add("test : ---");
        carStatus.add("car : -");

        OutputView outputView = new OutputView();
        outputView.printRacingCarStatus(carStatus);

        assertEquals("test : ---\r\ncar : -\r\n\r\n", outputStream.toString());
    }

}