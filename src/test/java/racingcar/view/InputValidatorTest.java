package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("자동차 이름들 중 빈 자동차 이름이 포함되어 예외가 발생한다.")
    @Test
    void checkEmptyName() {
        //given
        final List<String> names = List.of("bonsik", "soeun", "");

        //when & then
        assertThatThrownBy(() -> InputValidator.checkBlankAndDuplicationName(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름들 중 공백 자동차 이름이 포함되어 예외가 발생한다.")
    @Test
    void checkBlankName() {
        //given
        final List<String> names = List.of("bonsik", "soeun", " ");

        //when & then
        assertThatThrownBy(() -> InputValidator.checkBlankAndDuplicationName(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름들 중 중복된 자동차 이름이 포함되어 예외가 발생한다.")
    @Test
    void checkDuplicationName() {
        //given
        final List<String> names = List.of("bonsik", "soeun", "bonsik");

        //when & then
        assertThatThrownBy(() -> InputValidator.checkBlankAndDuplicationName(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

}