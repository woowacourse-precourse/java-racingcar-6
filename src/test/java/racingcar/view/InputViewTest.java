package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validation.InputValidator;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setup() {
        inputView = new InputView(new InputValidator());
    }

    @AfterEach
    void clean() {
        Console.close();
    }

    @DisplayName("경주할 자동차 입력받는다. 단, 비어있지 않다.")
    @ParameterizedTest
    @ValueSource(strings = {"\n"})
    void testInputCarNamesEmpty(String input) {
        InputStream in = generateInput(input);
        System.setIn(in);

        assertThrows(IllegalArgumentException.class,
                () -> inputView.inputCarNames());
    }

    @DisplayName("경주할 자동차를 입력받는다. 단, 공백일 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {" "})
    void testInputCarNamesBlank(String input) {
        InputStream in = generateInput(input);
        System.setIn(in);

        assertThrows(IllegalArgumentException.class,
                () -> inputView.inputCarNames());
    }

    @DisplayName("시도할 횟수를 입력받는다. 단, 숫자만 허용한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a"})
    void testInputTryCount(String input) {
        InputStream in = generateInput(input);
        System.setIn(in);

        assertThrows(IllegalArgumentException.class,
                () -> inputView.inputTryCount());
    }

    private static InputStream generateInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}