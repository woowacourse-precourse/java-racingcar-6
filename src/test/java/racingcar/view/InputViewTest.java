package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    public void InputView() {
        InputView inputView1 = InputView.getInstance();
        InputView inputView2 = InputView.getInstance();

        assertEquals(inputView1, inputView2);
    }
}