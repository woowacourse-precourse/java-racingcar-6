package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.Validator;

public class ValidatorTest {
    @ParameterizedTest
    @EmptySource
    void _빈_문자열_또는_Null_이름_입력(String nullAndEmpty) {
        assertThatThrownBy(() -> Validator.validNameFormat(nullAndEmpty)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @EmptySource
    void _빈_문자열_또는_Null_시도_횟수_입력(String nullAndEmpty) {
        assertThatThrownBy(() -> Validator.validIsNumber(nullAndEmpty)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"자동차1", "car11","*(&&",","})
    void _허용되지_않은_문자를_포함한_이름_입력(String testString) {
        assertThatThrownBy(() -> Validator.validNameFormat(testString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"name"})
    void _하나의_이름만_입력(String singleName) {
        assertThatThrownBy(() -> Validator.validSingleName(singleName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0"})
    void _0_시도_횟수_입력(String zero) {
        assertThatThrownBy(() -> Validator.validNotZero(zero)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"일", "two", "??"})
    void _숫자가_아닌_시도_횟수_입력(String testString) {
        assertThatThrownBy(() -> Validator.validIsNumber(testString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"차차차차차차", "carcarcar", "ccccccccccc"})
    void _허용되지_않은_길이의_이름_입력(String testString) {
        assertThatThrownBy(() -> Validator.validLength(testString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun,포비,우니,준"})
    void _허용되는_이름들_입력(String testString) {
        Validator.validNameFormat(testString);
        Validator.validSingleName(testString);
        assertThat(true).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "1", "1000"})
    void _허용되는_시도_횟수_입력(String testString) {
        Validator.validIsNumber(testString);
        Validator.validNotZero(testString);
        assertThat(true).isTrue();
    }
}
