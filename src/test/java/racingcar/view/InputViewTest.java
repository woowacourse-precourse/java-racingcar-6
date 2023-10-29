package racingcar.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private InputView inputView = new InputView();

    @Test
    void validate_이름문자열_주면_문자열반환() {
        String result = inputView.validateInput("test, him");
        assertThat(result).isEqualTo("test, him");
    }

    @Test
    void validate_숫자문자열_주면_문자열반환() {
        String result = inputView.validateInput("1");
        assertThat(result).isEqualTo("1");
    }

    @Test
    void validate_빈문자열_주면_예외반환() {
        assertThatThrownBy(() -> inputView.validateInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

}