package racingcar.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }

    @Test
    public void 자동차_이름_검증_예외_테스트() {
        String emptyInput = "";
        assertThatThrownBy(() -> inputView.validateCarNames(emptyInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 횟수_검증_예외_테스트1() {
        String numericInput = "";
        assertThatThrownBy(() -> inputView.validateAttempts(numericInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 횟수_검증_예외_테스트2() {
        String numericInput = "d";
        assertThatThrownBy(() -> inputView.validateAttempts(numericInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
