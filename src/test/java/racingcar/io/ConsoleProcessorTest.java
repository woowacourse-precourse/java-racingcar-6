package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsoleProcessorTest {

    private ConsoleProcessor consoleProcessor;

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUp() {
        consoleProcessor = new ConsoleProcessor();
    }

    @Test
    @DisplayName("자동차 이름들을 입력받아 쉼표로 자동차를 구분한다.")
    void registerCarNames_SplitWithComma() {
        // Given
        systemIn("자동차1,자동차2,자동차3");

        // When
        String[] result = consoleProcessor.registerCarNames();

        // Then
        assertThat(result)
                .hasSizeGreaterThanOrEqualTo(1)
                .contains("자동차1")
                .contains("자동차2")
                .contains("자동차3");
    }

}