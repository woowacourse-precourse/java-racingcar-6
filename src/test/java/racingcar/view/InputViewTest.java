package racingcar.view;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.constant.Constants;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private final InputView inputView = new InputView();

    @Test
    void extractAndValidateCarNames() {
        List<String> strings = inputView.extractAndValidateCarNames("car, car2");
        assertThat(strings.size()).isEqualTo(2);
        assertThat(strings).contains("car", "car2");
    }

    @Test
    void extractAndValidateRepeatCount() {
        int repeatCount = inputView.extractAndValidateRepeatCount("3");
        assertThat(repeatCount).isEqualTo(3);
    }

    @Test
    void validateCarName() {
        assertThatThrownBy(() -> inputView.validateCarName("overfive"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_INVALID_CAR_NAME);
    }

    @Test
    void isCarNameInvalid() {
        assertThat(inputView.isCarNameInvalid("test")).isFalse();
        assertThat(inputView.isCarNameInvalid("overfive")).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"  ,", "\n,", ","})
    void validateInput(String input) {
        assertThatThrownBy(() -> inputView.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_INVALID_CAR_NAME);
    }
}