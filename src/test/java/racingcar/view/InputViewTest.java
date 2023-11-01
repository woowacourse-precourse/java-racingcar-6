package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputView inputView;

    InputViewTest() {
        this.inputView = new InputView();
    }

    @Test
    void 이름_입력값의_앞뒤_공백_제거() {
        String[] names = {" a", " b ", "c  d"};
        System.setIn(new ByteArrayInputStream(String.join(",", names).getBytes()));
        assertEquals(inputView.readNames(), String.join(",", names).trim());
    }
}