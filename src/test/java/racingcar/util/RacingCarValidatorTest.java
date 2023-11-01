package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarValidatorTest {
    RacingCarValidator validator = new RacingCarValidator();
    List<String> list = new ArrayList<>();

    @Test
    void carNameLength() {
        list.add("1234");
        list.add("12345");
        assertThat(validator.carNameLength(list)).isEqualTo("ok");
        list.clear();

        assertThatThrownBy(() -> validator.carNameLength(list))
                .isInstanceOf(IllegalArgumentException.class);

        list.add("");
        assertThatThrownBy(() -> validator.carNameLength(list))
                .isInstanceOf(IllegalArgumentException.class);
        list.clear();

        list.add("");
        list.add("a");
        assertThatThrownBy(() -> validator.carNameLength(list))
                .isInstanceOf(IllegalArgumentException.class);
        list.clear();

        list.add("");
        list.add("");
        assertThatThrownBy(() -> validator.carNameLength(list))
                .isInstanceOf(IllegalArgumentException.class);
        list.clear();

        list.add("");
        list.add("a");
        list.add("");
        assertThatThrownBy(() -> validator.carNameLength(list))
                .isInstanceOf(IllegalArgumentException.class);
        list.clear();

        list.add("1");
        assertThatThrownBy(() -> validator.carNameLength(list))
                .isInstanceOf(IllegalArgumentException.class);
        list.clear();

        list.add("1");
        list.add("123456");
        assertThatThrownBy(() -> validator.carNameLength(list))
                .isInstanceOf(IllegalArgumentException.class);
        list.clear();
    }

    @Test
    void number() {
        assertThat(validator.number("1")).isSameAs(1);
        assertThat(validator.number("2")).isSameAs(2);
        assertThat(validator.number("10")).isSameAs(10);
        int maxValue = Integer.MAX_VALUE;
        String maxValueStr = String.valueOf(maxValue);
        assertThat(validator.number(maxValueStr)).isEqualTo(maxValue);

        assertThatThrownBy(() -> validator.number("a"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.number("1a"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.number("a1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.number("abc"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.number("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.number("-1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.number("-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputException() {
        assertThatThrownBy(() -> RacingCarValidator.inputException())
                .isInstanceOf(IllegalArgumentException.class);
    }
}