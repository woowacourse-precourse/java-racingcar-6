package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validation.InputValidator;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setup() {
        inputView = new InputView(new InputValidator());
    }

    @Test
    @DisplayName("경주할 자동차 입력받는다. 단, 비어있지 않다.")
    void testInputCarNamesEmpty() {
        String inputEmpty = "\n";
        InputStream in = new ByteArrayInputStream(inputEmpty.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class,
                () -> inputView.inputCarNames());
    }

    @Test
    @DisplayName("경주할 자동차를 입력받는다. 단, 공백일 수 없다.")
    void testInputCarNamesBlank() {
        String inputBlank = " ";
        InputStream in = new ByteArrayInputStream(inputBlank.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class,
                () -> inputView.inputCarNames());
    }

    @Test
    @DisplayName("시도할 횟수를 입력받는다. 단, 숫자만 허용한다.")
    void testInputTryCount() {
        String inputTryCount = "a";
        InputStream in = new ByteArrayInputStream(inputTryCount.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class,
                () -> inputView.inputTryCount());

    }

}