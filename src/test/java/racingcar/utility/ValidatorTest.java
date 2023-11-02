package racingcar.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    @DisplayName("입력 받은 값이 공백인 경우 true 반환한다.")
    void isBlank_true(String input) {
        // given & when
        boolean stringNull = Validator.isBlank(null);
        boolean result = Validator.isBlank(input);

        // then
        assertThat(stringNull).isTrue();
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"가나 다라", "rkfx", " 0"})
    @DisplayName("입력 받은 값이 공백이 아닌 경우 false 반환한다.")
    void isBlank_false(String input) {
        // given & when
        boolean result = Validator.isBlank(input);

        // then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456789", "123456", "가나다라마바사", "      0"})
    @DisplayName("전달받은 값이 5글자 이상인 경우 false 반환한다.")
    void isInNameRange_false() {
        // given & when
        boolean result = Validator.isInNameRange("result");

        // then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345", "1", "", " "})
    @DisplayName("전달받은 이름이 5글자 이하인 경우 true 반환한다.")
    void isInNameRange_true(String input) {
        // given & when
        boolean result = Validator.isInNameRange(input);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("전달받은 이름이 5글자 이하인 경우 true 반환한다.")
    void hasSameName_true() {
        // given & when
        List<String> koreanNames = Arrays.asList("가", "나", "가", "다");
        List<String> englishNames = Arrays.asList("pobi", "woni", "jun", "pobi");

        // then
        assertThat(Validator.hasSameName(koreanNames)).isTrue();
        assertThat(Validator.hasSameName(englishNames)).isTrue();
    }

    @Test
    @DisplayName("전달받은 이름들 중 중복된 값이 없는 경우 false 반환한다.")
    void hasSameName_false() {
        // given & when
        List<String> koreanNames = Arrays.asList("가", "나", "다", "라");
        List<String> englishNames = Arrays.asList("pobi", "woni", "jun", "gugi");

        // then
        assertThat(Validator.hasSameName(koreanNames)).isFalse();
        assertThat(Validator.hasSameName(englishNames)).isFalse();
    }

    @Test
    @DisplayName("중복값 체크 다양한 예시")
    void hasSameName_example() {
        // given & when
        List<String> notSame = Arrays.asList("가", "", "    ", "가나다", "^%&");
        List<String> same = Arrays.asList("1", "quankei", "!%&(", "1", "0", "0");

        // then
        assertThat(Validator.hasSameName(notSame)).isFalse();
        assertThat(Validator.hasSameName(same)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0123456789", "1510256", "471895236", "0123651741"})
    @DisplayName("숫자를 입력한 경우 true 반환한다.")
    void isNumber_true(String input) {
        // given & when
        String number = input;

        // then
        assertThat(Validator.isNumber(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1evc52", "  125", "ebick  2e5", "!!"})
    @DisplayName("숫자가 아닌 값을 입력한 경우 false 반환한다.")
    void isNumber_false() {
        // given & when
        String number = "1evc52";

        // then
        assertThat(Validator.isNumber(number)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "       "})
    @DisplayName("이름으로 공백을 입력한 경우 예외가 발생한다.")
    void validateInput_Exception(String input) {
        //given
        String expectedErrorMessage = "공백을 입력할 수 없습니다.";
        String blank = input;

        // when & then
        assertThatThrownBy(() -> Validator.validateInput(blank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"00000", "00", "0"})
    @DisplayName("0을 입력한 경우 true 반환한다.")
    void isZero_true(String input) {
        // given
        String zero = input;

        // when & then
        assertThat(Validator.isZero(zero)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"01234", "01", "1", "0152600"})
    @DisplayName("0이 아닌 값을 입력한 경우 true 반환한다.")
    void isZero_false(String input) {
        // given
        String notZero = input;

        // when & then
        assertThat(Validator.isZero(notZero)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345678", "01", "1", ""})
    @DisplayName("9자릿 수 이하로 입력한 경우 true 반환한다.")
    void isNumberWithinNineDigits_true(String input) {
        // given
        String inNineLength = input;

        // when &  then
        assertThat(Validator.isNumberWithinNineDigits(inNineLength)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234567890", "123456789000", "111111111111", "0000000001"})
    @DisplayName("9자릿 수 초과로 입력한 경우 false 반환한다.")
    void isNumberWithinNineDigits_false(String input) {
        // given
        String outNineLength = input;

        // when &  then
        assertThat(Validator.isNumberWithinNineDigits(outNineLength)).isFalse();
    }

    @Test
    @DisplayName("이름으로 중복된 값을 입력한 경우 예외가 발생한다")
    void validateNameList_exception_dupliName() {
        // given
        String expectedErrorMessage = "중복된 이름을 사용할 수 없습니다.";
        List<String> dupliList = Arrays.asList("pobi", "pobi");

        // when & then
        assertThatThrownBy(() -> Validator.validateNameList(dupliList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

    @Test
    @DisplayName("이름이 5자 초과인 경우 예외가 발생한다.")
    void validateNameList_exception_nameOutOfFive() {
        // given
        String expectedErrorMessage = "이름은 5자 이하로 입력해주세요.";
        List<String> excessList = Arrays.asList("12345", "123456", "1234");

        // when & then
        assertThatThrownBy(() -> Validator.validateNameList(excessList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1f54c1f5e", " fkcvne", "!  5c2e"})
    @DisplayName("숫자가 아닌 값을 입력한 경우 예외가 발생한다.")
    void validateGameCount_exception_notNumber(String input) {
        // given
        String expectedErrorMessage = "숫자만 입력해주세요.";
        String notNumber = input;

        // when & then
        assertThatThrownBy(() -> Validator.validateGameCount(notNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0000000", "0", "00"})
    @DisplayName("0을 입력한 경우 예외가 발생한다.")
    void validateGameCount_exception_zero(String input) {
        // given
        String expectedErrorMessage = "0 이상의 값을 입력해주세요.";
        String zero = input;

        // when & then
        assertThatThrownBy(() -> Validator.validateGameCount(zero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0123456789", "998877665544"})
    @DisplayName("9자릿수 초과로 입력한 경우 예외가 발생핸다.")
    void validateGameCount_exception_outOfNineLength(String input) {
        // given
        String expectedErrorMessage = "9자릿수까지 입력 가능합니다.";
        String outOfNine = input;

        // when & then
        assertThatThrownBy(() -> Validator.validateGameCount(outOfNine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

}