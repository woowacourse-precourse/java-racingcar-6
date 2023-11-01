package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameValidatorTest {

    @DisplayName("자동차들의 이름이 중복되 예외가 발생한다.")
    @Test
    void checkDuplicationName() {
        // given
        final List<String> names = Arrays.asList("bonsi", "soeun", "bonsi");

        // when & then
        assertThatThrownBy(() -> NameValidator.checkDuplicationName(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름의 길이가 5를 초과하여 예외가 발생한다.")
    @Test
    void checkNameLength() {
        //given
        final String name = "bonsik";

        //when & then
        assertThatThrownBy(() -> NameValidator.checkNameLength(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}