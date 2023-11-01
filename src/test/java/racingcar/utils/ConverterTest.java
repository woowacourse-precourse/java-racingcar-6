package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConverterTest {

    @DisplayName("숫자 형식이 아닐 경우 예외가 발생한다.")
    @Test
    void nonNumberFormatEx() {
        assertThatThrownBy(() -> Converter.toInt("가")).isInstanceOf(IllegalArgumentException.class);
    }
}
