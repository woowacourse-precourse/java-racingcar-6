package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;
    private String userInput;
    private InputStream inputStream;

    public InputViewTest() {
        this.inputView = InputView.getInstance();

    }

    public static InputStream parseUserInputToInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    public void InputView() {
        InputView inputView1 = InputView.getInstance();
        InputView inputView2 = InputView.getInstance();

        assertEquals(inputView1, inputView2);
    }

    @Test
    public void inputCarNames() {
        userInput = "pobi,woni,jun\n";
        inputStream = parseUserInputToInputStream(userInput);
        System.setIn(inputStream);

        List<String> expectedCarNames = List.of("pobi", "woni", "jun");
        List<String> carNames = inputView.inputCarNames();

        assertEquals(expectedCarNames, carNames);
    }
}