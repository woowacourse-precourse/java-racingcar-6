package racingcar.ViewTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import racingcar.View.InputView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {

    @Test
    @DisplayName("자동차명 입력 테스트")
    public void requestCarNamesTest() {
        setInput("ray,tico");
        String inputedCarNames = InputView.requestCarNames();
        assertEquals("ray,tico", inputedCarNames);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
