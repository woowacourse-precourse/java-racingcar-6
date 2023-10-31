package model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    void 숫자가_입력되지_않았을때_예외_처리() {
        String number = "test";
        assertThatThrownBy(() -> {
            new Round(number);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

}