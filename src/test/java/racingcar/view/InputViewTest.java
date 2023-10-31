package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    private final InputView inputView = new InputView();

    @BeforeEach
    void setUp() {
        Console.close();
    }

    @Test
    void 시도횟수_입력이_양의_정수일경우_정상적으로_진행() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        inputView.getTrials();
    }

    @ParameterizedTest
    @ValueSource(strings = {"5aa", "-5", "0"})
    void 시도횟수_입력_예외발생_테스트_문자포함_음수_0(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(inputView::getTrials).isInstanceOf(IllegalArgumentException.class);
    }

}