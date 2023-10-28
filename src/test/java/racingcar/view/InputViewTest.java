package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;
    private InputStream inputStream;

    public InputViewTest() {
        this.inputView = InputView.getInstance();
        inputStream = createInputStreams();
        System.setIn(inputStream);
    }

    private InputStream createInputStreams() {
        List<InputStream> inputStreams = Arrays.asList(
            parseUserInputToInputStream("pobi,woni,jun\n"),
            parseUserInputToInputStream("2\n"),
            parseUserInputToInputStream("non digit\n")
        );

        return new SequenceInputStream(Collections.enumeration(inputStreams));
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
        List<String> expectedCarNames = List.of("pobi", "woni", "jun");
        List<String> carNames = inputView.inputCarNames();

        assertEquals(expectedCarNames, carNames);
    }

    @Test
    public void inputNumberOfGameAttempts_success() {
        int expectedNumberOfGameAttempts = 2;
        int numberOfGameAttempts = inputView.inputNumberOfGameAttempts();

        assertEquals(expectedNumberOfGameAttempts, numberOfGameAttempts);
    }

    @Test
    public void inputNumberOfGameAttempts_fail() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.inputNumberOfGameAttempts();
        });
    }
}