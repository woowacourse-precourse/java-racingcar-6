package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ErrorTest {

    @Test
    void 이름이_5자_이하_일때_예외_발생() {
        String input = "pobidobi";

        assertThatThrownBy(() -> Error.check.isFiveLengthBelow(input.length()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이내로 입력해 주세요");
    }

    @Test
    void isAllInteger() {
        String input = "영";

        assertThatThrownBy(() -> Error.check.isAllInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해 주세요");
    }
}