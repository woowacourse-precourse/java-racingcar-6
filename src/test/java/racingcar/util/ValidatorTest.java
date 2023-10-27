package racingcar.util;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    @ParameterizedTest
    @DisplayName("빈값 입력 예외 테스트")
    @ValueSource(strings = {"", " ", "  ", "   "})
    void invalidInputsTest1(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isEmpty(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_VALUE);
    }

    @ParameterizedTest
    @DisplayName("이름 6자 이상 입력 예외 테스트")
    @ValueSource(strings = {"gildong", "홍2동1동길", "monster", " d wd d2w w  "})
    void invalidInputsTest2(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isLengthLessThanFive(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    private static Stream<Arguments> provideDuplicateTestCases() {
        return Stream.of(Arguments.of((Object) new String[]{"pobi", "pobi", "pobi"}),
                Arguments.of((Object) new String[]{"woni", "pobi", "woni"}),
                Arguments.of((Object) new String[]{"jun", "woni", "jun"}),
                Arguments.of((Object) new String[]{"woni", "jun", "jun"}));
    }

    @ParameterizedTest
    @DisplayName("중복된 자동차 이름을 입력 예외 테스트")
    @MethodSource("provideDuplicateTestCases")
    public void invalidInputsTest3(String[] inputs) {
        Assertions.assertThatThrownBy(() -> Validator.isDuplicateName(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않는 자동차 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @DisplayName("구분자를 잘못적어 입력한 예외 테스트")
    @ValueSource(strings = {"gil,,,dong", ",", ",,", ",,,,,,", "gil,,dong", "gil,", ",gil"})
    public void invalidInputsTest6(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isValidName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 이름입니다.");
    }

    @ParameterizedTest
    @DisplayName("정상적인 문자열 입력 모든 유효성 성공 테스트")
    @ValueSource(strings = {"pobi", "pobi,woni", "pobi,woni,jun", "pobi,John Doe,12345,woni"})
    void validInputsTest3(String input) {
        Assertions.assertThatCode(() -> Validator.isValidInput(input))
                .doesNotThrowAnyException();
    }

    private static Stream<Arguments> provideValidTestCases() {
        return Stream.of(Arguments.of((Object) new String[]{"1", "2", "3"}),
                Arguments.of((Object) new String[]{"woni", "pobi", "jun"}),
                Arguments.of((Object) new String[]{"pobhi", "javji", "1w"}),
                Arguments.of((Object) new String[]{"4ewr", "2qwe", "jpun"}));
    }

    @ParameterizedTest
    @DisplayName("경주할 자동차 이름 입력 모든 유효성 성공 테스트")
    @MethodSource("provideValidTestCases")
    void validInputsTest(String[] inputs) {
        Assertions.assertThatCode(() -> Validator.isValidCarName(inputs))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("1미만의 수를 입력 예외 테스트")
    @ValueSource(strings = {"0", "-151", "-001"})
    void invalidInputsTest4(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isOneOrMore(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1이상의 숫자만 가능합니다.");
    }

    @ParameterizedTest
    @DisplayName("int 형 값의 범위 초과 예외 테스트")
    @ValueSource(strings = {"2147483648", "92147483647"})
    void invalidInputsTest5(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isInRangeOfInt(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage("int 데이터 타입 값 범위 내로 입력하세요.");
    }

    @ParameterizedTest
    @DisplayName("시도할 횟수 입력 모든 유효성 성공 테스트")
    @ValueSource(strings = {"2147483647", "1", "999", "10", "001"})
    void validInputsTest2(String input) {
        Assertions.assertThatCode(() -> Validator.isValidAttemptCount(input))
                .doesNotThrowAnyException();
    }
}