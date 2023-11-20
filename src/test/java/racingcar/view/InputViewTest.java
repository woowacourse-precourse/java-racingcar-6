package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @DisplayName("숫자로 변경할 수 없는 값 입력시 애러")
    @Test
    void notNumberTest() {
        String input = "aa";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.inputRacingNum())
                .isInstanceOf(IllegalArgumentException.class);
    }

}