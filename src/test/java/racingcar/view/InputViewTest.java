package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    @DisplayName("올바르지 않은 회수를 입력하면 오류가 발생한다.")
    void 회수_검증() {
        //given
        InputView inputView = new InputView();
        String input = "a";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        Assertions.assertThatThrownBy(() -> inputView.inputCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력하세요.");
    }

}