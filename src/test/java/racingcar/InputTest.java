package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;

public class InputTest {

    InputView inputView = new InputView();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-234", "-13423"})
    void 진행횟수_입력값이_음수인경우(String inputNegative) {
        System.setIn(createUserInput(inputNegative));

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.inputRaceTimes();
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "00", "000", "00000000"})
    void 진행횟수_입력값이_0인경우(String inputZero) {
        System.setIn(createUserInput(inputZero));

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.inputRaceTimes();
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"g", "xyz", "g35e", "  "})
    void 진행횟수_입력값이_숫자가_아닐경우(String inputNoNumber) {
        System.setIn(createUserInput(inputNoNumber));

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.inputRaceTimes();
        });
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
