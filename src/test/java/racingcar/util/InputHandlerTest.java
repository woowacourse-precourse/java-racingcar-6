package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    @ValueSource(strings = {"pobi,woni,jun", "5"})
    void 사용자가_문자열을_입력했을때_값이_정상적으로_리턴_되는지_확인한다(String inputValue) {
        setInput(inputValue);
        String expected = inputValue;

        String actualed = InputHandler.getUserInputString();

        assertThat(actualed).isEqualTo(expected);
    }

    @Test
    void 사용자가_문자열을_입력해야만_했을때_값을_입력하지_않는다면_에러가_출력_되는지_확인한다() {
        setInput("\n");

        assertThatThrownBy(() -> {
            InputHandler.getUserInputString();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 사용자가_숫자를_입력했을때_값이_정상적으로_리턴_되는지_확인한다(String inputValue) {
        setInput(inputValue);
        Integer expected = Integer.parseInt(inputValue);

        Integer actualed = InputHandler.getUserInputNumber();

        assertThat(actualed).isEqualTo(expected);
    }

    @Test
    void 사용자가_숫자를_입력해야만_했을때_값을_입력하지_않는다면_에러가_출력_되는지_확인한다() {
        setInput("\n");

        assertThatThrownBy(() -> {
            InputHandler.getUserInputNumber();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", ")", "!"})
    void 사용자가_숫자를_입력해야만_했을때_숫자말고_다른걸_입력_했을때_에러가_출력_되는지_확인한다(String inputValue) {
        setInput(inputValue);

        assertThatThrownBy(() -> {
            InputHandler.getUserInputNumber();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
