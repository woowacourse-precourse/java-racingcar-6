package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "    ", "     ", "\n", "\t", "\r"})
    @DisplayName("[ERROR] 경주할 자동차 이름을 입력하세요.")
    void blank(String wrongInput) {
        InputView inputView = new InputView(() -> wrongInput);
        Assertions.assertThatThrownBy(() -> inputView.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi/ssss"})
    @DisplayName("[ERROR] 경주할 자동차 이름은 쉼표로 구분해서 작성하세요.")
    void comma(String wrongInput) {
        InputView inputView = new InputView(() -> wrongInput);
        Assertions.assertThatThrownBy(() -> inputView.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,susu", "pobi,wooni"})
    @DisplayName("[ERROR] 자동차 이름은 5자이하로 작성해야합니다.")
    void lengthExceed(String wrongInput) {
        InputView inputView = new InputView(() -> wrongInput);
        Assertions.assertThatThrownBy(() -> inputView.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
