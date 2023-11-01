package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.Validator;

public class ValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {" ", "자동차1", "car11","*(&&", ","})
    void _허용되지_않은_문자를_포함한_이름_입력(String testString) {
        assertThatThrownBy(() -> Validator.validNameFormat(testString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "일", "two", "??"})
    void _허용되지_않은_문자를_포함한_시도_횟수_입력(String testString) {
        assertThatThrownBy(() -> Validator.validIsNumber(testString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"차차차차차차", "carcarcar", "ccccccccccc"})
    void _허용되지_않은_길이의_문자_입력(String testString) {
        assertThatThrownBy(() -> Validator.validLength(testString)).isInstanceOf(IllegalArgumentException.class);
    }
}
