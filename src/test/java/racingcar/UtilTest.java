package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UtilTest {
    @ParameterizedTest
    @ValueSource(strings = {"aespa,thirsty"})
    void handleCarNamesException_이름길이_기준치_이상_입력(String input) {
        assertThatThrownBy(() -> Util.handleCarNamesException(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(MessageType.CAR_NAMES_LENGTH_ERR.getDetail());
    }

    @ParameterizedTest
    @ValueSource(strings = {"aespa,aespa"})
    void handleCarNamesException_중복되는_이름_입력(String input) {
        assertThatThrownBy(() -> Util.handleCarNamesException(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(MessageType.CAR_NAMES_DUPLICATE_ERR.getDetail());
    }

    @ParameterizedTest
    @ValueSource(strings = {"NewJeans"})
    void handleTryNumberException_정수가_아닌_입력(String input) {
        assertThatThrownBy(() -> Util.handleTryNumberException(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(MessageType.TRY_NUMBER_INPUT_ERR.getDetail());
    }
}
