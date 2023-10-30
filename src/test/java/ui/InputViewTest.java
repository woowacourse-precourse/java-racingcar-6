package ui;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @Test
    void inputCarNames_ValidInput() {
        String input = "car1,car2,car3";
        provideInput(input);

        assertThat(InputView.inputCarNames()).containsExactly("car1", "car2", "car3");
    }

    @Test
    void inputCarNames_CarNameLength() {
        String input = "car1,car2,car3456789";
        provideInput(input);

        assertThatThrownBy(InputView::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void inputCarNames_NameContainsNoSpace() {
        String input = "car1,car 2,car3";
        provideInput(input);

        assertThatThrownBy(InputView::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 공백은 불가능합니다.");
    }

    @Test
    void inputCarNames_NamesDuplicate() {
        String input = "car1,car2,car1";
        provideInput(input);

        assertThatThrownBy(InputView::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 중복은 불가능합니다.");
    }

    @Test
    void inputNumberOfTries_ValidInput() {
        String input = "5";
        provideInput(input);

        assertThat(InputView.inputNumberOfTries()).isEqualTo(5);
    }

    @Test
    void inputNumberOfTries_NegativeInput() {
        String input = "-3";
        provideInput(input);

        assertThatThrownBy(InputView::inputNumberOfTries)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수 라운드 입력은 불가능합니다.");
    }

    private void provideInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}