package view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {
    @Test
    void 사용자에게서_숫자_입력_받기() {
        InputView inputView = new InputView();
        assertThat(inputView.getUserInput()).isEqualTo("123");
    }
}
