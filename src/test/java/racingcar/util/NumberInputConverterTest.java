package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NumberInputConverterTest {

    @Test
    void String을_숫자로_변환할_수_있다() {
        int number = NumberInputConverter.convert("123456");
        assertThat(number).isEqualTo(123456);
    }

    @Test
    void String을_숫자로_변환시_숫자가_아닌경우_IllegalArgumentException이_발생한다() {
        assertThatThrownBy(() -> NumberInputConverter.convert("77숫자아님77"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
