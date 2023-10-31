package racingcar.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameCheckTest {

    @Test
    void 입력값이_없을_때_예외_발생() {
        String input = "";
        assertThatThrownBy(() -> CarNameCheck.isNothing(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백이_있을_때_예외_발생() {
        String input = "car name";
        assertThatThrownBy(() -> CarNameCheck.isIncludeBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_5자를_넘으면_예외_발생() {
        String input = "car_name";
        assertThatThrownBy(() -> CarNameCheck.isOverFive(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}