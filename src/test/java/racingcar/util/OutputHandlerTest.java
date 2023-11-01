package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.constants.PrintMesssages;

class OutputHandlerTest {
    private final PrintStream originalOutput = System.out;
    private OutputStream outputCaptor;
    private final String newLine = System.lineSeparator();

    @BeforeEach
    void testInit() {
        outputCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCaptor));
    }

    @AfterEach
    void testCleanUp() {
        System.setOut(originalOutput);
    }

    @ParameterizedTest
    @MethodSource("getAllPrintMessages")
    void 각종_메세지가_콘솔에_출력_되는지_확인한다(String message) {
        OutputHandler.showMessageWithNewLine(message);
        String expectedMessage = message + newLine;

        String actualedMessage = outputCaptor.toString();

        assertThat(actualedMessage).isEqualTo(expectedMessage);
    }

    private static List<String> getAllPrintMessages() {
        return Arrays.stream(PrintMesssages.values())
                .map(v -> v.getMessage())
                .toList();
    }
}