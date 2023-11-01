package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private final InputStream standardIn = System.in;

    @AfterEach
    public void restoreStreams() {
        System.setIn(standardIn);
    }

    @Test
    void getUserInputTest() {
        //given
        String userInput = "테스트 입력";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        //when
        InputView inputView = new InputView();
        String result = inputView.getUserInput();

        //then
        assertEquals(userInput, result);
    }
}