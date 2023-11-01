package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.TestCommon;
import racingcar.constants.PrintMesssages;

class OutputHandlerTest extends TestCommon {
    @ParameterizedTest
    @MethodSource("getAllPrintMessages")
    void 각종_메세지가_콘솔에_출력_되는지_확인한다(String message) {
        OutputHandler.showMessageWithNewLine(message);
        String expectedMessage = message + NEW_LINE;

        String actualedMessage = getOutput();

        assertThat(actualedMessage).isEqualTo(expectedMessage);
    }

    private static List<String> getAllPrintMessages() {
        return Arrays.stream(PrintMesssages.values())
                .map(v -> v.getMessage())
                .toList();
    }
}