package racingcar.util;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.ErrorCode;

class ValidatorTest {
    private final Validator validator = new Validator();

    @ParameterizedTest
    @DisplayName("이름을 입력받았을 때, 이름의 길이가 5를 초과하면 예외가 발생한다.")
    @ValueSource(strings = {"pobi,crongc,heys", "pobipo,crong,hey"})
    public void should_throwException_when_InvalidNameLength(String input) {
        assertThatThrownBy(() -> validator.validateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_NAME_LENGTH.toString());
    }

    @ParameterizedTest
    @DisplayName("이름을 입력받았을 때, 중복되는 이름이 존재하는 경우 예외가 발생한다.")
    @ValueSource(strings = {"pobi,pobi,crong", "crong,crong,pobi"})
    public void should_throwException_when_NameDuplicated(String input) {
        assertThatThrownBy(() -> validator.validateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATED_NAME.toString());
    }
}