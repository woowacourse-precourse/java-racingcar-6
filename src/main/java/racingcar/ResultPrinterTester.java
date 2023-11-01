package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ResultPrinterTester {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("올바른 결과를 출력하는지 확인한다.")
    public void testResult() {
        ResultPrinter resultPrinter = new ResultPrinter();
        resultPrinter.printResult("woni", 4);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("woni : ----");
    }
}
