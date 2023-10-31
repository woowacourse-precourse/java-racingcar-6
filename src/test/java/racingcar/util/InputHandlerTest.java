package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputHandlerTest {
    private final InputStream originalInput = System.in;

    private void setInput(String inputValue) {
        System.setIn(new ByteArrayInputStream(inputValue.getBytes()));
    }
    @BeforeEach
    void testInit() {

    }

    @AfterEach
    void testCleanUp() {
        System.setIn(originalInput);
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings =  {"pobi,woni,jun", "5"})
    void 사용자가_입력한_값이_정상적으로_리턴_되는지_확인한다(String inputValue) {
        setInput(inputValue);
        String expected = inputValue;

        String actualed = InputHandler.getUserInput();

        assertThat(actualed).isEqualTo(expected);
    }
}